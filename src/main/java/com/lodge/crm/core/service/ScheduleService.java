package com.lodge.crm.core.service;

import java.util.List;

import com.lodge.crm.core.entity.hibernate.Schedule;
import com.lodge.crm.core.util.JqgridFilter;

public interface ScheduleService extends BaseJqGridService<Schedule,Integer>{
	List<Schedule> findBySchedulePid(Integer schedulePid);
	
	List<Schedule> findAll(JqgridFilter jqgridFilter);
}
