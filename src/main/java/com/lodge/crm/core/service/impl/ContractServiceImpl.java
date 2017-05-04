package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.Contract;
import com.lodge.crm.core.service.ContractService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="contractService")
@Transactional
public class ContractServiceImpl implements ContractService {

	@Override
	public Page<Contract> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(Contract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatInBatch(Iterable<Contract> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(Contract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Contract> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(Contract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<Contract> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contract> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Contract> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract findOne(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
