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
import com.lodge.crm.core.entity.hibernate.Course;
import com.lodge.crm.core.repository.CourseRepository;
import com.lodge.crm.core.service.CourseService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="courseService")
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepository;

	@Override
	public Boolean create(Course entity) {
		Course newCourse = courseRepository.saveAndFlush(entity);
		if(newCourse == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Course> entities) {
		courseRepository.save(entities);
		
	}

	@Override
	public Boolean delete(Course entity) {
		courseRepository.delete(entity);
		Course exisitCourse = courseRepository.findOne(entity.getCourseCode());
		if(exisitCourse !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Course> entities) {
		courseRepository.deleteInBatch(entities);
		
	}

	@Override
	public Boolean update(Course entity) {
		Course exisitCourse = courseRepository.saveAndFlush(entity);
		if(exisitCourse == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Course> entities) {
		courseRepository.save(entities);
		
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Page<Course> findAll(Pageable pageable) {
		return courseRepository.findAll(pageable);
	}
	
	@Override
	public Course findOne(String code) {
		return courseRepository.findOne(code);
	}
	
	@Override
	public Page<Course> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Course> spec = getWhereClause(jqgridFilter);
		return courseRepository.findAll(spec, pageable);
	}

	private Specification<Course> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Course>() {
        	@Override
			 public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder cb){
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
}
