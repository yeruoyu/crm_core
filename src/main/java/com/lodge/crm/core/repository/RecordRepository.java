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
	 * @param customerId  //  order by cr.recordId desc
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT cr FROM CustomerRecord cr JOIN cr.recordCustomer c WHERE c.customerCode = ?1"
			,countQuery="SELECT COUNT(cr) FROM CustomerRecord cr JOIN cr.recordCustomer c WHERE c.customerCode = ?1")
	public Page<CustomerRecord> findByCustomerCode(String customerCode,Pageable pageable);
	
	
	/*
		SELECT CR.* FROM CUSTOMER C
		INNER JOIN USER U
		ON C.LAST_USER = U.USER_CODE
		INNER JOIN CUSTOMER_RECORD CR
		ON C.CUSTOMER_CODE = CR.RECORD_CUSTOMER
		WHERE U.USER_CODE='U00002'
		AND C.CUSTOMER_STATUS=1 
		AND CR.RECORD_NTIME IS NOT NULL
		ORDER BY CR.RECORD_NTIME
*/
}
