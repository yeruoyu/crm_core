package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lodge.crm.core.entity.hibernate.TableKey;
import com.lodge.crm.core.repository.TableKeyRepository;
import com.lodge.crm.core.service.TableKeyService;
import com.lodge.crm.core.util.StringUtil;

@Service(value ="tableKeyService" )
public class TableKeyServiceImpl implements TableKeyService {

	@Autowired
	TableKeyRepository tableKeyRepository;
	
	@Override
	public Boolean create(TableKey entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatInBatch(Iterable<TableKey> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(TableKey entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<TableKey> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(TableKey entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<TableKey> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TableKey> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TableKey> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableKey findOne(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNewCode(String code){
		// 获取最大值;
		TableKey  key = tableKeyRepository.findTableKeyByCode(code);
		Integer maxId = key.getMax()+1;
		String newCode = key.getCode()+StringUtil.lpad(key.getLength(),maxId);
		
		key.setMax(maxId);
		tableKeyRepository.saveAndFlush(key);
		
		return newCode;
	}
}
