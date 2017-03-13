package com.lodge.crm.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.Area;

public interface AreaRepository extends JpaRepository<Area, String>,JpaSpecificationExecutor<Area>{
	
	@Query(value="SELECT a FROM Area a WHERE a.areaCode like '%0000'")
	public List<Area> findByAllArea();
	
	@Query(value="SELECT a FROM Area a WHERE a.areaCode like ?1 and a.areaCode <>?2")
	public List<Area> findByAreaCode(String cityCode,String areaCode);
}
