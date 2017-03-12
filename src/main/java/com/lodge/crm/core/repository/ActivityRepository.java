package com.lodge.crm.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.Activity;

public interface ActivityRepository extends JpaRepository<Activity, String>,JpaSpecificationExecutor<Activity> {

	@Query(value="SELECT a FROM Activity a WHERE a.activityStatus=1 AND a.activityStartDate>= ?")
	public List<Activity> findEnableActivity(Date currentDate);
	
}
