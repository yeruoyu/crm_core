package com.lodge.crm.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.entity.hibernate.CustomerActivity;

public interface CustomerActivityService extends BaseJqGridService<CustomerActivity,Long> {
	public Page<CustomerActivity> findByCustomerCode(String customerCode,Pageable pageable);
}
