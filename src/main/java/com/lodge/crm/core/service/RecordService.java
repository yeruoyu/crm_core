package com.lodge.crm.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.entity.hibernate.CustomerRecord;

public interface RecordService extends BaseJqGridService<CustomerRecord,Long> {
	public Page<CustomerRecord> findByCustomerCode(String customerCode,Pageable pageable);
}
