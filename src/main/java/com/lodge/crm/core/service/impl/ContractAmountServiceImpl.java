package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.ContractAmount;
import com.lodge.crm.core.service.ContractAmountService;
import com.lodge.crm.core.util.JqgridFilter;
@Service(value="contractAmountService")
@Transactional
public class ContractAmountServiceImpl implements ContractAmountService {

	@Override
	public Page<ContractAmount> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(ContractAmount entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatInBatch(Iterable<ContractAmount> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(ContractAmount entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<ContractAmount> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(ContractAmount entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<ContractAmount> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ContractAmount> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractAmount> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContractAmount findOne(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
