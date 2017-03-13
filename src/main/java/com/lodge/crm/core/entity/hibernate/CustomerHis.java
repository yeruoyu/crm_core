package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="CUSTOMER_HIS")
public class CustomerHis implements Serializable {

	private static final long serialVersionUID = -1270419561056445301L;
	
	/** 履历编号，主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HISTORY_ID")
	private Integer historyId;

	/** 客户代码 */
	@Column(name="CUSTOMER_CODE")
	private String customerCode;
	
	/** 客户姓名 */
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	/** 客户英文名/昵称 */
	@Column(name="CUSTOMER_ENAME")
	private String customerEName;
	
	/** 客户性别 */
	@Column(name="CUSTOMER_SEX")
	private Integer customerSex;
	
	/** 身份证 */
	@Column(name="CUSTOMER_CREDIT")
	private String customerCredit;
	
	/** 出生年月 */
	@Column(name="CUSTOMER_BIRTHDAY")
	private String customerBirthday;
	
	/** 目前所在学校  */
	@Column(name="CUSTOMER_SCHOOL")
	private String customerSchool;
	
	/** 现在年级  */
	@Column(name="CUSTOMER_GRADE")
	private String customerGrade;
	
	/** 现在专业  */
	@Column(name="CUSTOMER_MAJOR")
	private String customerMajor;
	
	/** 意向专业  */
	@Column(name="INTENTION_MAJOR")
	private String intentionMajor;
	
	/** 意向国家  */
	@Column(name="INTENTION_COUNTRY")
	private String intentionContry;
	
	/** 意向状态 */
	@Column(name="INTENTION_STATUS")
	private String intentionStatus;
	
	/** 负责人 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LAST_USER", insertable = true,updatable = true)
	private User customerPrincipal;
	
	/** 客户对应渠道 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CHANNEL", insertable = true,updatable = true)
	private Channel customerChannel;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_GROUP", insertable = true,updatable = true)
	private Group customerGroup;
	
	@Column(name="CUSTOMER_PHONE1")
	private String customerPhone1;
	
	@Column(name="CUSTOMER_PHONE2")
	private String customerPhone2;

	
	/** 客户默认手机 ,作为客户唯一性验证*/
	@Column(name="CUSTOMER_MOBILE1",unique=true)
	private String customerMobile1;
	
	@Column(name="CUSTOMER_MOBILE2")
	private String customerMobile2;
	
	/** E-Mail */
	@Column(name="CUSTOMER_EMAIL")
	private String customerEmail;
	
	/** QQ */
	@Column(name="CUSTOMER_QQ")
	private String customerQq;

	/** 微信 */
	@Column(name="CUSTOMER_WEBCHAT")
	private String customerWeiChat;
	
	/** 省  */
	@Column(name="CUSTOMER_PROVINCE")
	private String customerProvince;
	
	/** 市 */
	@Column(name="CUSTOMER_CITY")
	private String customerCity;
	
	/** 邮编 */
	@Column(name="CUSTOMER_ZIPCODE")
	private String customerZipcode;
	
	/** 地址 */
	@Column(name="CUSTOMER_ADDRESS")
	private String customerAddress;
	
	/** 锁定状态 */
	@Column(name="CUSTOMER_LOCKED")
	private Integer customerLocked;
	
	/** 客户备注 */
	@Column(name="CUSTOMER_COMMENTS")
	private String customerComments;
	
	/** 客户级别 */
	@Column(name="CUSTOMER_LEVEL")
	private Integer customerLevel;
		
	/** 客户状态(未报名:0 | 顾问退回:-1 | 市场退回:-2 -> 已报名:1 -> 合同签定:2-> 已付款:3-> 开始上课:4 -> 课程结束:9) */
	@Column(name="CUSTOMER_STATUS")
	private Integer customerStatus;

	/** 结算状态(未结算:0 -> 已结算:1 -> 已退回:-2) */
	@Column(name="ACCOUNT_STATUS")
	private Integer accountStatus;
	
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

	public String getCustomerEName() {
		return customerEName;
	}

	public void setCustomerEName(String customerEName) {
		this.customerEName = customerEName;
	}

	public Integer getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(Integer customerSex) {
		this.customerSex = customerSex;
	}

	public String getCustomerCredit() {
		return customerCredit;
	}

	public void setCustomerCredit(String customerCredit) {
		this.customerCredit = customerCredit;
	}

	public String getCustomerBirthday() {
		return customerBirthday;
	}

	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	public String getCustomerSchool() {
		return customerSchool;
	}

	public void setCustomerSchool(String customerSchool) {
		this.customerSchool = customerSchool;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public String getCustomerMajor() {
		return customerMajor;
	}

	public void setCustomerMajor(String customerMajor) {
		this.customerMajor = customerMajor;
	}

	public String getIntentionMajor() {
		return intentionMajor;
	}

	public void setIntentionMajor(String intentionMajor) {
		this.intentionMajor = intentionMajor;
	}

	public String getIntentionContry() {
		return intentionContry;
	}

	public void setIntentionContry(String intentionContry) {
		this.intentionContry = intentionContry;
	}

	public String getIntentionStatus() {
		return intentionStatus;
	}

	public void setIntentionStatus(String intentionStatus) {
		this.intentionStatus = intentionStatus;
	}

	public User getCustomerPrincipal() {
		return customerPrincipal;
	}

	public void setCustomerPrincipal(User customerPrincipal) {
		this.customerPrincipal = customerPrincipal;
	}

	public Channel getCustomerChannel() {
		return customerChannel;
	}

	public void setCustomerChannel(Channel customerChannel) {
		this.customerChannel = customerChannel;
	}

	public Group getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(Group customerGroup) {
		this.customerGroup = customerGroup;
	}

	public String getCustomerPhone1() {
		return customerPhone1;
	}

	public void setCustomerPhone1(String customerPhone1) {
		this.customerPhone1 = customerPhone1;
	}

	public String getCustomerPhone2() {
		return customerPhone2;
	}

	public void setCustomerPhone2(String customerPhone2) {
		this.customerPhone2 = customerPhone2;
	}

	public String getCustomerMobile1() {
		return customerMobile1;
	}

	public void setCustomerMobile1(String customerMobile1) {
		this.customerMobile1 = customerMobile1;
	}

	public String getCustomerMobile2() {
		return customerMobile2;
	}

	public void setCustomerMobile2(String customerMobile2) {
		this.customerMobile2 = customerMobile2;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerQq() {
		return customerQq;
	}

	public void setCustomerQq(String customerQq) {
		this.customerQq = customerQq;
	}

	public String getCustomerWeiChat() {
		return customerWeiChat;
	}

	public void setCustomerWeiChat(String customerWeiChat) {
		this.customerWeiChat = customerWeiChat;
	}

	public String getCustomerProvince() {
		return customerProvince;
	}

	public void setCustomerProvince(String customerProvince) {
		this.customerProvince = customerProvince;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerZipcode() {
		return customerZipcode;
	}

	public void setCustomerZipcode(String customerZipcode) {
		this.customerZipcode = customerZipcode;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Integer getCustomerLocked() {
		return customerLocked;
	}

	public void setCustomerLocked(Integer customerLocked) {
		this.customerLocked = customerLocked;
	}

	public String getCustomerComments() {
		return customerComments;
	}

	public void setCustomerComments(String customerComments) {
		this.customerComments = customerComments;
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

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	public List<ContactInfo> getContactInfoList() {
		return contactInfoList;
	}

	public void setContactInfoList(List<ContactInfo> contactInfoList) {
		this.contactInfoList = contactInfoList;
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

	public List<CustomerContract> getCustContractList() {
		return custContractList;
	}

	public void setCustContractList(List<CustomerContract> custContractList) {
		this.custContractList = custContractList;
	}

	public String getCreatUserCode() {
		return creatUserCode;
	}

	public void setCreatUserCode(String creatUserCode) {
		this.creatUserCode = creatUserCode;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}
	
	public CustomerHis(){
		
	}

	// 
	public CustomerHis(Customer customer){
		this.setCustomerCode(customer.getCustomerCode());
		this.setCustomerName(customer.getCustomerName());
		this.setCustomerEName(customer.getCustomerEName());
		this.setCustomerSex(customer.getCustomerSex());
		this.setCustomerCredit(customer.getCustomerCredit());
		this.setCustomerBirthday(customer.getCustomerBirthday());
		this.setCustomerSchool(customer.getCustomerSchool());
		this.setCustomerGrade(customer.getCustomerGrade());
		this.setCustomerMajor(customer.getCustomerMajor());
		this.setIntentionMajor(customer.getIntentionMajor());
		this.setIntentionContry(customer.getIntentionContry());
		this.setIntentionStatus(customer.getIntentionStatus());
		this.setCustomerPrincipal(customer.getCustomerPrincipal());
		this.setCustomerChannel(customer.getCustomerChannel());
		this.setCustomerGroup(customer.getCustomerGroup());
		this.setCustomerPhone1(customer.getCustomerPhone1());
		this.setCustomerPhone2(customer.getCustomerPhone2());
		this.setCustomerMobile1(customer.getCustomerMobile1());
		this.setCustomerMobile2(customer.getCustomerMobile2());
		this.setCustomerEmail(customer.getCustomerEmail());
		this.setCustomerQq(customer.getCustomerQq());
		this.setCustomerWeiChat(customer.getCustomerWeiChat());
		this.setCustomerProvince(customer.getCustomerProvince());
		this.setCustomerCity(customer.getCustomerCity());
		this.setCustomerZipcode(customer.getCustomerZipcode());
		this.setCustomerAddress(customer.getCustomerAddress());
		this.setCustomerLocked(customer.getCustomerLocked());
		this.setCustomerComments(customer.getCustomerComments());
		this.setCustomerLevel(customer.getCustomerLevel());
		this.setCustomerStatus(customer.getCustomerStatus());
		this.setAccountStatus(customer.getAccountStatus());
		this.setCreatUserCode(customer.getCreatUser().getUserCode());
		this.setCreateTime(customer.getCreateTime());
		this.setUpdateUserCode(customer.getUpdateUserCode());
		this.setUpdateTime(customer.getUpdateTime());

	}
	
}
