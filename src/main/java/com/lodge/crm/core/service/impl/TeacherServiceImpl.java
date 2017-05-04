package com.lodge.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.common.Constants;
import com.lodge.crm.core.entity.hibernate.Teacher;
import com.lodge.crm.core.repository.TeacherRepository;
import com.lodge.crm.core.service.TeacherService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public Boolean create(Teacher entity) {
		Teacher newTeacher = teacherRepository.saveAndFlush(entity);
		if(newTeacher == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Teacher> entities) {
		teacherRepository.save(entities);
	}

	@Override
	public Boolean delete(Teacher entity) {
		teacherRepository.delete(entity);
		Teacher exisitTeacher = teacherRepository.findOne(entity.getTeacherCode());
		if(exisitTeacher !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Teacher> entities) {
		teacherRepository.deleteInBatch(entities);
	}

	@Override
	public Boolean update(Teacher entity) {
		Teacher exisitTeacher = teacherRepository.saveAndFlush(entity);
		if(exisitTeacher == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Teacher> entities) {
		teacherRepository.save(entities);
	}

	@Override
	public List<Teacher> findAll() {
		List<Teacher> teachers =  teacherRepository.findAll();
		for(Teacher teacher:teachers){
			this.getTeacherDetailInfo(teacher);
		}
		return teachers;
	}

	@Override
	public Page<Teacher> findAll(Pageable pageable) {
		Page<Teacher> teachers =  teacherRepository.findAll(pageable);
		for(Teacher teacher:teachers){
			this.getTeacherDetailInfo(teacher);
		}
		return teachers;
	}

	@Override
	public Teacher findOne(String code) {
		Teacher teacher = teacherRepository.findOne(code);
        if(teacher == null) {
            return null;
        }
        this.getTeacherDetailInfo(teacher);

        return teacher;
	}
	
	@Override
	public Page<Teacher> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Teacher> spec = getWhereClause(jqgridFilter);
		return teacherRepository.findAll(spec, pageable);
	}
	
	private Specification<Teacher> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Teacher>() {
        	@Override
			 public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
						if(rule.getOp().equals("eq")){
							predicate.add(cb.equal(root.get(rule.getField()).as(String.class), rule.getData()));
						}
					}
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
        };
    }

	private void getTeacherDetailInfo(Teacher teacher){
	}
}
