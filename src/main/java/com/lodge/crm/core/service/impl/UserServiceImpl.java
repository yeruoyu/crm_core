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
import com.lodge.crm.core.entity.hibernate.User;
import com.lodge.crm.core.repository.UserRepository;
import com.lodge.crm.core.service.UserService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Boolean create(User entity) {
		User newUser = userRepository.saveAndFlush(entity);
		if(newUser == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<User> entities) {
		userRepository.save(entities);

	}

	@Override
	public Boolean delete(User entity) {
		userRepository.delete(entity);
		User exisitUser = userRepository.findOne(entity.getUserCode());
		if(exisitUser !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<User> entities) {
		userRepository.deleteInBatch(entities);
	}

	@Override
	public Boolean update(User entity) {
		User exisitUser = userRepository.saveAndFlush(entity);
		if(exisitUser == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<User> entities) {
		userRepository.save(entities);
	}

	@Override
	public List<User> findAll() {
		List<User> users =  userRepository.findAll();
		for(User user:users){
			this.getUserDetailInfo(user);
		}
		return users;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		Page<User> users =  userRepository.findAll(pageable);
		for(User user:users){
			this.getUserDetailInfo(user);
		}
		return users;
	}

	@Override
	public User findOne(String code) {
		User user = userRepository.findOne(code);
        if(user == null) {
            return null;
        }
        this.getUserDetailInfo(user);
        
        if(user.getParentUser()!=null){
        	this.getUserDetailInfo(user.getParentUser());
        }
        
        return user;
	}
	
	@Override
	public User findbyEmailAccount(String emailCount){
		List<User> userList = userRepository.findbyEmailAccount(emailCount);
		if(userList==null || userList.size()==0){
			return null;
		}
		
		User user = userList.get(0);
		if(user == null) {
            return null;
        }		
		this.getUserDetailInfo(user);
        
        if(user.getParentUser()!=null){
        	this.getUserDetailInfo(user.getParentUser());
        }
        
        return user;
	}
	
	private void getUserDetailInfo(User user){
		
		user.getCustomerList().size();
        user.getLockHistoryList().size();
        user.getOperateLogList().size();
        user.getRecordList().size();
        user.getSchoolList().size();
	}
	
	@Override
	public Page<User> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<User> spec = getWhereClause(jqgridFilter);
		return userRepository.findAll(spec, pageable);
	}
	
	private Specification<User> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<User>() {
        	@Override
			 public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb){
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
