package com.lodge.crm.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.CustomerActivity;

public interface CustomerActivityRepository extends
		JpaRepository<CustomerActivity, Long>,
		JpaSpecificationExecutor<CustomerActivity> {

	@Query(value="SELECT ca FROM CustomerActivity ca JOIN ca.customer c WHERE c.customerCode = ?1 order by ca.caId"
			,countQuery="SELECT COUNT(ca) FROM CustomerActivity ca JOIN ca.customer c WHERE c.customerCode = ?1")
	public Page<CustomerActivity> findByCustomerCode(String customerCode,Pageable pageable);
}
