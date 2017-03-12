package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable {

	private static final long serialVersionUID = -6742173070625992768L;

	/** 员工工号(登录名) */
	@Id
	@Column(name="USER_CODE")
	private String userCode;
	
	/** 员工姓名 */
	@Column(name="USER_NAME")
	private String userName;
	
	/** 员工登录密码 */
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	/** 员工联系座机 */
	@Column(name="USER_PHONE")
	private String userPhone;
	
	/** 员工联系手机 */
	@Column(name="USER_MOBILE")
	private String userMobile;
	
	/** 员工联系地址 */
	@Column(name="USER_ADDRESS")
	private String userAddress;
	
	/** 员工Email */
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	/** 员工QQ */
	@Column(name="USER_QQ")
	private String userQq;
	
	/** 员工微信号 */
	@Column(name="USER_WEBCHAT")
	private String userWebchat;
	
	/** 员工状态 */
	@Column(name="USER_STATUS")
	private Integer userStatus;
	
	/** 客户记录集 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lastUser",fetch=FetchType.LAZY )
	private List<Customer> customerList;
	
	/** 联系客户记录集 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recordUser",fetch=FetchType.LAZY )
	private List<CustomerRecord> recordList;
	
	/** 操作日志 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "logUser",fetch=FetchType.LAZY )
	private List<OperateLog> operateLogList;

	/** 锁定客户记录集 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lockUser",fetch=FetchType.LAZY )
	private List<CustomerUser> lockHistoryList;
	
	@ManyToMany(mappedBy="userList",cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
	private List<Role> roleList;

	@ManyToMany(mappedBy="userList",cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
	private List<School> schoolList;
	
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getUserWebchat() {
		return userWebchat;
	}

	public void setUserWebchat(String userWebchat) {
		this.userWebchat = userWebchat;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<OperateLog> getOperateLogList() {
		return operateLogList;
	}

	public void setOperateLogList(List<OperateLog> operateLogList) {
		this.operateLogList = operateLogList;
	}

	public List<CustomerRecord> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<CustomerRecord> recordList) {
		this.recordList = recordList;
	}

	public List<CustomerUser> getLockHistoryList() {
		return lockHistoryList;
	}

	public void setLockHistoryList(List<CustomerUser> lockHistoryList) {
		this.lockHistoryList = lockHistoryList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<School> getSchoolList() {
		return schoolList;
	}

	public void setSchoolList(List<School> schoolList) {
		this.schoolList = schoolList;
	}

}