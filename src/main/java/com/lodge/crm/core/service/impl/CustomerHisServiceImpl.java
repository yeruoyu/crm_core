package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.CustomerHis;
import com.lodge.crm.core.repository.CustomerHisRepository;
import com.lodge.crm.core.service.CustomerHisService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="customerHisService")
@Transactional
public class CustomerHisServiceImpl implements CustomerHisService {

	@Autowired
	CustomerHisRepository customerHisRepository;
	
	@Override
	public Page<CustomerHis> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(CustomerHis entity) {
		CustomerHis newCustomerHis = customerHisRepository.saveAndFlush(entity);
		if(newCustomerHis == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<CustomerHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(CustomerHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<CustomerHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(CustomerHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<CustomerHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CustomerHis> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerHis> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerHis findOne(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

}
