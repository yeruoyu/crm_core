package com.lodge.crm.core.service;

import java.util.List;

import com.lodge.crm.core.entity.hibernate.Area;

public interface AreaService extends BaseService<Area,String>{

	public List<Area> findByAllArea();

	public List<Area> findByAreaCode(String areaCode);
}
