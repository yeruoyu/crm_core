package com.lodge.crm.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.entity.hibernate.CustomerProject;

public interface CustomerProjectService extends BaseJqGridService<CustomerProject,Long>{
	
	public Page<CustomerProject> findByCustomerCode(String customerCode,Pageable pageable);
}
