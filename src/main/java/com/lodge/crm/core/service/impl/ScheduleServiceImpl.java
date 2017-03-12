package com.lodge.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.common.Constants;
import com.lodge.crm.core.entity.hibernate.Schedule;
import com.lodge.crm.core.entity.hibernate.User;
import com.lodge.crm.core.repository.ScheduleRepository;
import com.lodge.crm.core.service.ScheduleService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="scheduleService")
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;

	@Override
	public Boolean create(Schedule entity) {
		Schedule newSchedule = scheduleRepository.saveAndFlush(entity);
		if(newSchedule == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Schedule> entities) {
		scheduleRepository.save(entities);
	}

	@Override
	public Boolean delete(Schedule entity) {
		scheduleRepository.delete(entity);
		Schedule exisitSchedule = scheduleRepository.findOne(entity.getScheduleId());
		if(exisitSchedule !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Schedule> entities) {
		scheduleRepository.deleteInBatch(entities);
	}

	@Override
	public Boolean update(Schedule entity) {
		Schedule exisitSchedule = scheduleRepository.saveAndFlush(entity);
		if(exisitSchedule == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Schedule> entities) {
		scheduleRepository.save(entities);
	}

	@Override
	public List<Schedule> findAll() {
		return scheduleRepository.findAll();
	}

	@Override
	public Page<Schedule> findAll(Pageable pageable) {
		return scheduleRepository.findAll(pageable);
	}

	@Override
	public Schedule findOne(Integer code) {
		Schedule schedule = scheduleRepository.findOne(code);
		return schedule;
	}
	
	@Override
	public List<Schedule> findBySchedulePid(Integer schedulePid){
		return scheduleRepository.findBySchedulePid(schedulePid);
	}
	
	@Override
	public Page<Schedule> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Schedule> spec = getWhereClause(jqgridFilter);
		return scheduleRepository.findAll(spec, pageable);
	}
	
	@Override
	public List<Schedule> findAll(JqgridFilter jqgridFilter){
		Specification<Schedule> spec = getWhereClause(jqgridFilter);
		return scheduleRepository.findAll(spec);
	}
	
	private Specification<Schedule> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Schedule>() {
        	@Override
			 public Predicate toPredicate(Root<Schedule> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
						if(rule.getOp().equals("eq")){
							if(rule.getField().equals("scheduleUser")){
								Join<Schedule,User> uesrJoin = root.join(root.getModel().getSingularAttribute("scheduleUser", User.class), JoinType.INNER);
								predicate.add(cb.equal(uesrJoin.get("userCode").as(String.class), rule.getData()));
							}else{
								predicate.add(cb.equal(root.get(rule.getField()).as(String.class),rule.getData()));
							}
						}
					}
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
        };
    }
}
