package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.ContractHis;
import com.lodge.crm.core.service.ContractHisService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="contractHisService")
@Transactional
public class ContractHisServiceImpl implements ContractHisService {

	@Override
	public Page<ContractHis> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(ContractHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatInBatch(Iterable<ContractHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(ContractHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<ContractHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(ContractHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<ContractHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ContractHis> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContractHis> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContractHis findOne(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

}
