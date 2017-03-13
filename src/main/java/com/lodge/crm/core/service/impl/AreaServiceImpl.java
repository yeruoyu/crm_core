package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.Area;
import com.lodge.crm.core.repository.AreaRepository;
import com.lodge.crm.core.service.AreaService;

@Service(value="areaService")
@Transactional
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaRepository areaRepository;
	
	@Override
	public Boolean create(Area entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatInBatch(Iterable<Area> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(Area entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Area> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(Area entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<Area> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Area> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Area findOne(String code) {
		return areaRepository.findOne(code);
	}

	@Override
	public List<Area> findByAllArea() {
		return areaRepository.findByAllArea();
	}

	@Override
	public List<Area> findByAreaCode(String areaCode) {
		String cityCode = areaCode.substring(0,2)+"%00";
		return areaRepository.findByAreaCode(cityCode,areaCode);
	}

}
