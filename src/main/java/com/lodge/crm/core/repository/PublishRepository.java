package com.lodge.crm.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.Publish;

public interface PublishRepository  extends JpaRepository<Publish, Integer>,JpaSpecificationExecutor<Publish>{
	
	@Query(value="SELECT pb FROM Publish pb WHERE pb.publishStatus=1 ORDER BY pb.publishUTime",
			countQuery="SELECT COUNT(pb) FROM Publish pb WHERE pb.publishStatus=1 ORDER BY pb.publishUTime")
	public Page<Publish> findAllActive(Pageable pageable);
}
