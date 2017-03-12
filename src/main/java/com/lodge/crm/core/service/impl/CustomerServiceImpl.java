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
import com.lodge.crm.core.entity.hibernate.Channel;
import com.lodge.crm.core.entity.hibernate.Customer;
import com.lodge.crm.core.entity.hibernate.School;
import com.lodge.crm.core.entity.hibernate.User;
import com.lodge.crm.core.repository.CustomerRepository;
import com.lodge.crm.core.service.CustomerService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="customerService")
@Transactional
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Boolean create(Customer entity) {
		Customer newCustomer = customerRepository.saveAndFlush(entity);
		if(newCustomer == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Customer> entities) {
		customerRepository.save(entities);
		
	}

	@Override
	public Boolean delete(Customer entity) {
		customerRepository.delete(entity);
		Customer exisitCustomer = customerRepository.findOne(entity.getCustomerCode());
		if(exisitCustomer !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Customer> entities) {
		customerRepository.deleteInBatch(entities);
	}

	@Override
	public Boolean update(Customer entity) {
		Customer exisitCustomer = customerRepository.saveAndFlush(entity);
		if(exisitCustomer == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Customer> entities) {
		customerRepository.save(entities);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@Override
	public Customer findOne(String code) {
		Customer customer = customerRepository.findOne(code);
		customer.getLockHistoryList().size();
		return customer;
	}

	@Override
	public Page<Customer> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Customer> spec = getWhereClause(jqgridFilter);
		return customerRepository.findAll(spec, pageable);
	}
	
	private Specification<Customer> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Customer>() {
        	@Override
			 public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
						if(rule.getOp().equals("eq")){
							if(rule.getField().equals("userCode")){
								Join<Customer,User> uesrJoin = root.join(root.getModel().getSingularAttribute("lastUser", User.class), JoinType.INNER);
								predicate.add(cb.equal(uesrJoin.get("userCode").as(String.class), rule.getData()));
							}
							else if(rule.getField().equals("channelCode")){
								Join<Customer,Channel> channelJoin = root.join(root.getModel().getSingularAttribute("channel", Channel.class), JoinType.INNER);
								predicate.add(cb.equal(channelJoin.get("channelCode").as(String.class), rule.getData()));
							}else if(rule.getField().equals("schoolCode")){
								Join<Customer,School> schoolJoin = root.join(root.getModel().getSingularAttribute("group", School.class), JoinType.INNER);
								predicate.add(cb.equal(schoolJoin.get("schoolCode").as(String.class), rule.getData()));
							}else{
								predicate.add(cb.equal(root.get(rule.getField()).as(String.class), rule.getData()));
							}
						}
					}
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
        };
    }
	
	public Page<Customer> findUnlockCustomer(String userCode,Pageable pageable){
		return this.customerRepository.findUnlockCustomer(userCode, pageable);
	}
	

	public boolean checkCustomerUnquire(String customerCode,String custMobile){
		Customer customer = this.customerRepository.findCustomerByCustomerMobile(custMobile);
		if(customer!=null){
			if(customerCode!=null && !customerCode.isEmpty() && customerCode.equals(customer.getCustomerCode())){
				return true;
			}else{
				return false;
			}
		}
		return true;
	}
}
