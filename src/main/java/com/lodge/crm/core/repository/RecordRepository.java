package com.lodge.crm.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.CustomerRecord;

public interface RecordRepository  extends JpaRepository<CustomerRecord, Long>,JpaSpecificationExecutor<CustomerRecord> {
	/**
	 * 根据客户ID查询联系信息
	 * @param customerId
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT cr FROM CustomerRecord cr JOIN cr.recordCustomer c WHERE c.customerCode = ?1 order by cr.recordId"
			,countQuery="SELECT COUNT(cr) FROM CustomerRecord cr JOIN cr.recordCustomer c WHERE c.customerCode = ?1")
	public Page<CustomerRecord> findByCustomerCode(String customerCode,Pageable pageable);
}
