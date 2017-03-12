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
import com.lodge.crm.core.entity.hibernate.School;
import com.lodge.crm.core.repository.SchoolRepository;
import com.lodge.crm.core.service.SchoolService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="schoolService")
@Transactional
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	public SchoolRepository schoolRespository;

	@Override
	public Boolean create(School entity) {
		School newSchool = schoolRespository.saveAndFlush(entity);
		if(newSchool == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<School> entities) {
		schoolRespository.save(entities);
	}

	@Override
	public Boolean delete(School entity) {
		schoolRespository.delete(entity);
		School exisitSchool = schoolRespository.findOne(entity.getSchoolCode());
		if(exisitSchool !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<School> entities) {
		schoolRespository.deleteInBatch(entities);
		
	}

	@Override
	public Boolean update(School entity) {
		School exisitSchool = schoolRespository.saveAndFlush(entity);
		if(exisitSchool == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<School> entities) {
		schoolRespository.save(entities);
		
	}

	@Override
	public List<School> findAll() {
		return schoolRespository.findAll();
	}

	@Override
	public Page<School> findAll(Pageable pageable) {
		return schoolRespository.findAll(pageable);
	}

	@Override
	public School findOne(String code) {
		School school = schoolRespository.findOne(code);
		if(school == null) {
            return null;
        }
		return school;
	}
	
	@Override
	public Page<School> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<School> spec = getWhereClause(jqgridFilter);
		return schoolRespository.findAll(spec, pageable);
	}

	private Specification<School> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<School>() {
        	@Override
			 public Predicate toPredicate(Root<School> root, CriteriaQuery<?> query, CriteriaBuilder cb){
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
