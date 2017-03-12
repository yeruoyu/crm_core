package com.lodge.crm.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.entity.hibernate.ContactInfo;

public interface ContactInfoService extends BaseJqGridService<ContactInfo,Long>{
	Page<ContactInfo> findContactByCustCode(String customerCode,Pageable pageable);
	
	ContactInfo findContactByContactMobile(String mobile);
	
	Boolean checkContactByMobile(String mobile,Long contactId);
}
