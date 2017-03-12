package com.lodge.crm.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.DistInfo;

public interface DistInfoRepository extends JpaRepository<DistInfo, Integer>,
JpaSpecificationExecutor<DistInfo> {

	@Query(value="SELECT di FROM DistInfo di WHERE di.distType =?1",
			countQuery="SELECT COUNT(di) FROM DistInfo di WHERE di.distType =?1")
	public List<DistInfo> findDistInfoByType(String distType);
}
