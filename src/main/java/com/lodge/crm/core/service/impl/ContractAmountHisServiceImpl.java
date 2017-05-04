package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.ContractAmountHis;
import com.lodge.crm.core.service.ContractAmountHisService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="contractAmountHisService")
@Transactional
public class ContractAmountHisServiceImpl implements ContractAmountHisService {

	@Override
	public Page<ContractAmountHis> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(ContractAmountHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatInBatch(Iterable<ContractAmountHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(ContractAmountHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<ContractAmountHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(ContractAmountHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<ContractAmountHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ContractAmountHis> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractAmountHis> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContractAmountHis findOne(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

}
