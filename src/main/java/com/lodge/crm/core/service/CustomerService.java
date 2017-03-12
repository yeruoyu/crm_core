package com.lodge.crm.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.entity.hibernate.Customer;

public interface CustomerService extends BaseJqGridService<Customer,String> {

	/**
	 * 根据客户所属组获取未被锁定的客户
	 * @param userGroup
	 * @param pageable
	 * @return
	 */
	public Page<Customer> findUnlockCustomer(String userGroup,Pageable pageable);
	
	/**
	 * 根据用户的Mobile验证客户是否是唯一的。
	 * @param custMobile
	 * @return
	 */
	public boolean checkCustomerUnquire(String customerCode,String custMobile);
}
