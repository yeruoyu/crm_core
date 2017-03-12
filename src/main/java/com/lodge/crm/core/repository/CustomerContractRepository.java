package com.lodge.crm.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.CustomerContract;

public interface CustomerContractRepository extends
JpaRepository<CustomerContract, Long>, JpaSpecificationExecutor<CustomerContract> {
	
	@Query(value="SELECT cc FROM CustomerContract cc JOIN cc.customer c WHERE c.customerCode = ?1 order by cc.ccId"
			,countQuery="SELECT COUNT(cc) FROM CustomerContract cc JOIN cc.customer c WHERE c.customerCode = ?1")
	public Page<CustomerContract> findByCustomerCode(String customerCode,Pageable pageable);
}
