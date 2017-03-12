package com.lodge.crm.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.entity.hibernate.CustomerContract;

public interface CustomerContractService extends BaseJqGridService<CustomerContract,Long> {
	public Page<CustomerContract> findByCustomerCode(String customerCode,Pageable pageable);
}
