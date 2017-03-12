package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 客户信息表
 * @author Administrator
 *
 */
@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = -1270419561056445301L;
	
	/** 客户代码，主键 */
	@Id
	@Column(name="CUSTOMER_CODE")
	private String customerCode;
	
	/** 客户姓名 */
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	/** 客户级别 */
	@Column(name="CUSTOMER_LEVEL")
	private Integer customerLevel;
		
	/** 客户状态(未报名:0 | 顾问退回:-1 | 市场退回:-2 -> 已报名:1 -> 合同签定:2-> 已付款:3-> 开始上课:4 -> 课程结束:9) */
	@Column(name="CUSTOMER_STATUS")
	private Integer customerStatus;

	/** 结算状态(未结算:0 -> 已结算:1 -> 已退回:-2) */
	@Column(name="ACCOUNT_STATUS")
	private Integer accountStatus;

	/** 客户备注 */
	@Column(name="CUSTOMER_COMMENTS")
	private String customerComments;
	
	
	/** 客户对应的员工 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LAST_USER", insertable = true,updatable = true)
	private User lastUser;

	/** 客户所属团队 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CUSTOMER_GROUP", insertable = true,updatable = true)
	private School group;
	
	/** 客户对应渠道 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CHANNEL", insertable = true,updatable = true)
	private Channel channel;
	
	/** 关联客户信息 - 可能会有重复的客户，只是登记人不同。 */
	@OneToMany(mappedBy="refCustomer")
	private List<Customer> refCustomerList;
	
	/** 关联客户信息 - 可能会有重复的客户，只是登记人不同。 */
	@ManyToOne
	@JoinColumn(name="REF_CUSTOMER_CODE")
	private Customer refCustomer;
	
	/** 客户默认手机 ,作为客户唯一性验证*/
	@Column(name="CUSTOMER_MOBILE",unique=true)
	private String customerMobile;

	/**
	 * 客户联系方式
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.EAGER )
	private List<ContactInfo> contactInfoList;
	
	/** 客户联系记录 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recordCustomer",fetch=FetchType.LAZY )
	private List<CustomerRecord> recordList;

	/** 客户锁定记录 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lockCustomer",fetch=FetchType.LAZY )
	private List<CustomerUser> lockHistoryList;
	
	/** 客户对应的项目记录 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.LAZY )
	private List<CustomerProject> custProjectList;
	
	/** 客户对应的活动记录 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.LAZY )
	private List<CustomerActivity> custActivityList;
	
	/** 客户所关心的国家  */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.LAZY )
	private List<CustomerCountry> custCountryList;
	
	/** 客户所关心的学校  */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.LAZY )
	private List<CustomerSchool> custSchoolList;
	
	/** 客户签订的合同 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.LAZY )
	private List<CustomerContract> custContractList;

	/** 创建用户Code */
	@Column(name="CREATE_USER")
	private String creatUserCode;
	
	/** 创建时间 */
	@Column(name="CREATE_TIME")
	private Timestamp createTime;
	
	/** 修改用户Code */
	@Column(name="UPDATE_USER")
	private String updateUserCode;
	
	/** 修改时间 */
	@Column(name="UPDATE_TIME")
	private Timestamp updateTime;
	
	/** 锁定状态 */
	@Column(name="CUSTOMER_LOCKED")
	private Integer customerLocked;

	/** 客户专业 */
	@Column(name="CUSTOMER_COURSE")
	private Integer customerCourse;
	
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(Integer customerLevel) {
		this.customerLevel = customerLevel;
	}

	public Integer getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
		this.customerStatus = customerStatus;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<ContactInfo> getContactInfoList() {
		return contactInfoList;
	}

	public void setContactInfoList(List<ContactInfo> contactInfoList) {
		this.contactInfoList = contactInfoList;
	}


	public List<CustomerProject> getCustProjectList() {
		return custProjectList;
	}

	public void setCustProjectList(List<CustomerProject> custProjectList) {
		this.custProjectList = custProjectList;
	}

	public List<CustomerActivity> getCustActivityList() {
		return custActivityList;
	}

	public void setCustActivityList(List<CustomerActivity> custActivityList) {
		this.custActivityList = custActivityList;
	}

	public List<CustomerCountry> getCustCountryList() {
		return custCountryList;
	}

	public void setCustCountryList(List<CustomerCountry> custCountryList) {
		this.custCountryList = custCountryList;
	}

	public List<CustomerSchool> getCustSchoolList() {
		return custSchoolList;
	}

	public void setCustSchoolList(List<CustomerSchool> custSchoolList) {
		this.custSchoolList = custSchoolList;
	}

	public School getGroup() {
		return group;
	}

	public void setGroup(School group) {
		this.group = group;
	}

	public User getLastUser() {
		return lastUser;
	}

	public void setLastUser(User lastUser) {
		this.lastUser = lastUser;
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

	public Integer getCustomerLocked() {
		return customerLocked;
	}

	public void setCustomerLocked(Integer customerLocked) {
		this.customerLocked = customerLocked;
	}

	public List<CustomerContract> getCustContractList() {
		return custContractList;
	}

	public void setCustContractList(List<CustomerContract> custContractList) {
		this.custContractList = custContractList;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public List<Customer> getRefCustomerList() {
		return refCustomerList;
	}

	public void setRefCustomerList(List<Customer> refCustomerList) {
		this.refCustomerList = refCustomerList;
	}

	public Customer getRefCustomer() {
		return refCustomer;
	}

	public void setRefCustomer(Customer refCustomer) {
		this.refCustomer = refCustomer;
	}

	public String getCreatUserCode() {
		return creatUserCode;
	}

	public void setCreatUserCode(String creatUserCode) {
		this.creatUserCode = creatUserCode;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public String getCustomerComments() {
		return customerComments;
	}

	public void setCustomerComments(String customerComments) {
		this.customerComments = customerComments;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public Integer getCustomerCourse() {
		return customerCourse;
	}

	public void setCustomerCourse(Integer customerCourse) {
		this.customerCourse = customerCourse;
	}

}
