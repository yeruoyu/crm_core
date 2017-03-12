package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.CustomerProject;
import com.lodge.crm.core.repository.CustomerProjectRepository;
import com.lodge.crm.core.service.CustomerProjectService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="customerProjectService")
@Transactional
public class CustomerProjectServiceImpl implements CustomerProjectService {

	@Autowired
	CustomerProjectRepository customerProjectRepository;
	
	@Override
	public Page<CustomerProject> findAll(JqgridFilter jqgridFilter,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(CustomerProject entity) {
		customerProjectRepository.saveAndFlush(entity);
		return true;
	}

	@Override
	public void creatInBatch(Iterable<CustomerProject> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(CustomerProject entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<CustomerProject> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(CustomerProject entity) {
		customerProjectRepository.saveAndFlush(entity);
		return true;
	}

	@Override
	public void updateInBatch(Iterable<CustomerProject> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CustomerProject> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerProject> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerProject findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerProject> findByCustomerCode(String customerCode,
			Pageable pageable) {
		return customerProjectRepository.findByCustomerCode(customerCode, pageable);
	}

}
