package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.CustomerActivity;
import com.lodge.crm.core.repository.CustomerActivityRepository;
import com.lodge.crm.core.service.CustomerActivityService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="customerActivityService")
@Transactional
public class CustomerActivityServiceImpl implements CustomerActivityService{

	@Autowired
	CustomerActivityRepository customerActivityRepository;
	
	@Override
	public Page<CustomerActivity> findAll(JqgridFilter jqgridFilter,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(CustomerActivity entity) {
		customerActivityRepository.saveAndFlush(entity);
		return true;
	}

	@Override
	public void creatInBatch(Iterable<CustomerActivity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean delete(CustomerActivity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<CustomerActivity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean update(CustomerActivity entity) {
		customerActivityRepository.saveAndFlush(entity);
		return true;
	}

	@Override
	public void updateInBatch(Iterable<CustomerActivity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerActivity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerActivity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerActivity findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerActivity> findByCustomerCode(String customerCode,
			Pageable pageable) {
		return this.customerActivityRepository.findByCustomerCode(customerCode, pageable);
	}

}
