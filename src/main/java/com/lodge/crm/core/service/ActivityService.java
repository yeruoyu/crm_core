package com.lodge.crm.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.entity.hibernate.Activity;
import com.lodge.crm.core.util.JqgridFilter;

public interface ActivityService extends BaseService<Activity,String> {
	
	public Page<Activity> findAll(JqgridFilter jqgridFilter, Pageable pageable);
	
	public List<Activity> findEnableActivity();
}
