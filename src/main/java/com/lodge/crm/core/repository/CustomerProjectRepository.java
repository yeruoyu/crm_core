package com.lodge.crm.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.CustomerProject;

public interface CustomerProjectRepository extends
		JpaRepository<CustomerProject, Long>, JpaSpecificationExecutor<CustomerProject> {
	/**
	 * 根据客户ID查询项目信息
	 * @param customerId
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT cp FROM CustomerProject cp JOIN cp.customer c WHERE c.customerCode = ?1 order by cp.cpId"
			,countQuery="SELECT COUNT(cp) FROM CustomerProject cp JOIN cp.customer c WHERE c.customerCode = ?1")
	public Page<CustomerProject> findByCustomerCode(String customerCode,Pageable pageable);
}
