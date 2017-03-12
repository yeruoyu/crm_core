package com.lodge.crm.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.lodge.crm.core.entity.hibernate.Activity;
import com.lodge.crm.core.repository.ActivityRepository;
import com.lodge.crm.core.service.ActivityService;
import com.lodge.crm.core.util.DateUtils;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="activityService")
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityRepository activityRepository;
	
	@Override
	public Boolean create(Activity entity) {
		Activity newActivity = activityRepository.saveAndFlush(entity);
		if(newActivity == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Activity> entities) {
		activityRepository.save(entities);
	}

	@Override
	public Boolean delete(Activity entity) {
		activityRepository.delete(entity);
		Activity exisitActivity = activityRepository.findOne(entity.getActivityCode());
		if(exisitActivity !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Activity> entities) {
		activityRepository.deleteInBatch(entities);
	}

	@Override
	public Boolean update(Activity entity) {
		Activity exisitActivity = activityRepository.saveAndFlush(entity);
		if(exisitActivity == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Activity> entities) {
		activityRepository.save(entities);
	}

	@Override
	public List<Activity> findAll() {
		return activityRepository.findAll();
	}

	@Override
	public Page<Activity> findAll(Pageable pageable) {
		return activityRepository.findAll(pageable);
	}
	
	@Override
	public List<Activity> findEnableActivity(){
		Date currentDate = DateUtils.getCurrentDateTime();
		return activityRepository.findEnableActivity(currentDate);
	}


	@Override
	public Activity findOne(String code) {
		return activityRepository.findOne(code);
	}

	@Override
	public Page<Activity> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Activity> spec = getWhereClause(jqgridFilter);
		return activityRepository.findAll(spec, pageable);
	}
	
	private Specification<Activity> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Activity>() {
        	@Override
			 public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
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
