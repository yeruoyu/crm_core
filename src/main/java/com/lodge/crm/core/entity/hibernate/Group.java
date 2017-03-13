package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 公司团队 可以作为子公司使用
 * @author Administrator
 *
 */
@Entity
@Table(name="COMPANY")
public class Group implements Serializable{

	private static final long serialVersionUID = -5789357489500036055L;

	/** 团队主键 */
	@Id
	@Column(name="GROUP_CODE")
	private String groupCode;
	
	/** 团队名称 */
	@Column(name="GROUP_NAME")
	private String groupName;
	
	@Column(name="GROUP_STATUS")
	private Integer groupStatus;
	
	/** 团队对应的用户 */
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "userGroup",fetch=FetchType.LAZY )
	private List<User> userList;
	
	/** 团队对应的客户 */
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "customerGroup",fetch=FetchType.LAZY )
	private List<Customer> customerList;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public Integer getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(Integer groupStatus) {
		this.groupStatus = groupStatus;
	}
	
}
