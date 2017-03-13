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
import com.lodge.crm.core.entity.hibernate.Group;
import com.lodge.crm.core.repository.GroupRepository;
import com.lodge.crm.core.service.GroupService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="groupService")
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository groupRepository;
	


	@Override
	public Boolean create(Group entity) {
		Group newGroup = groupRepository.saveAndFlush(entity);
		if(newGroup ==null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Group> entities) {
		groupRepository.save(entities);
	}

	@Override
	public Boolean delete(Group entity) {
		groupRepository.delete(entity);
		Group exisitGroup = groupRepository.findOne(entity.getGroupCode());
		if(exisitGroup !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Group> entities) {
		groupRepository.deleteInBatch(entities);
	}

	@Override
	public Boolean update(Group entity) {
		Group exisitGroup = groupRepository.saveAndFlush(entity);
		if(exisitGroup == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Group> entities) {
		groupRepository.save(entities);
	}

	@Override
	public List<Group> findAll() {
		return groupRepository.findAll();
	}

	@Override
	public Page<Group> findAll(Pageable pageable) {
		return groupRepository.findAll(pageable);
	}

	@Override
	public Group findOne(String code) {
		Group group = groupRepository.findOne(code);
        if(group == null) {
            return null;
        }
        this.getGroupDetailInfo(group);
        return group;
	}
	
	private void getGroupDetailInfo(Group group){
		group.getCustomerList().size();
		group.getUserList().size();
	}
	
	@Override
	public Page<Group> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Group> spec = getWhereClause(jqgridFilter);
		return groupRepository.findAll(spec, pageable);
	}
	
	private Specification<Group> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Group>() {
        	@Override
			 public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
					}
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
        };
    }
}
