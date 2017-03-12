package com.lodge.crm.core.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.ContactInfo;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long>,JpaSpecificationExecutor<ContactInfo> {

	@Query(value="SELECT ci FROM ContactInfo ci join ci.customer c WHERE c.customerCode =?1",
			countQuery="SELECT COUNT(ci) FROM ContactInfo ci join ci.customer c WHERE c.customerCode =?1")
	public Page<ContactInfo> findContactByCustCode(String customerCode,Pageable pageable);
	
	/**
	 * 根据手机查询客户联系信息
	 * @param mobile
	 * @return
	 */
	public ContactInfo findContactByContactMobile(String mobile);
}
