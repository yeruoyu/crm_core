package com.lodge.crm.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>,JpaSpecificationExecutor<Schedule> {

	@Query(value="SELECT sc FROM Schedule sc WHERE sc.schedulePid=?1")
	public List<Schedule> findBySchedulePid(Integer schedulePid);
}
