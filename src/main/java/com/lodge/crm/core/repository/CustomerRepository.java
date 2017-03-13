package com.lodge.crm.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>,JpaSpecificationExecutor<Customer> {

	/**
	 * 根据客户所属组获取未被锁定的客户
	 * @param userGroup
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT c FROM Customer c JOIN c.customerGroup g JOIN g.userList u WHERE u.userCode =?1 AND c.customerStatus = 1 AND c.customerLocked = 0 AND c.accountStatus = 0 ORDER BY c.customerCode",
			countQuery="SELECT COUNT(c) FROM Customer c JOIN c.customerGroup g JOIN g.userList u WHERE u.userCode =?1 AND c.customerStatus = 1 AND c.customerLocked = 0 AND c.accountStatus = 0")
	public Page<Customer> findUnlockCustomer(String userCode,Pageable pageable);

	/**
	 * 根据员工ID获取员工所对应的客户
	 * @param userCode
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT c FROM Customer c JOIN c.customerGroup g JOIN g.userList u WHERE u.userCode =?1 AND c.customerStatus = 1 AND c.accountStatus = 0 ORDER BY c.customerCode",
			countQuery="SELECT COUNT(c) FROM Customer c JOIN c.customerGroup g JOIN g.userList u WHERE u.userCode =?1 AND c.customerStatus = 1 AND c.accountStatus = 0")
	public Page<Customer> findUserCustomer(String userCode,Pageable pageable);
	
	/**
	 * 根据用户手机查询用户
	 * @param customerMobile1
	 * @return
	 */
	public Customer findCustomerByCustomerMobile1(String customerMobile1);
}
