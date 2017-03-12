package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_INFO")
public class ContactInfo implements Serializable{

	private static final long serialVersionUID = 7325898655527785061L;

	/** 主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTACT_ID")
	private Long contactId;

	/** 区域 */
	@Column(name="CONTACT_LOCAL")
	private String contactLocal;
	
	/** 联系人 */
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	/** 联系地址  */
	@Column(name="CONTACT_ADDRESS")
	private String contactAddress;
	
	/** 邮编  */
	@Column(name="CONTACT_ZIP")
	private String contactZip;
	
	/** 电话 */
	@Column(name="CONTACT_PHONE")
	private String contactPhone;
	
	/** 手机 */
	@Column(name="CONTACT_MOBILE")
	private String contactMobile;
	
	/** EMAIL */
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	/** QQ */
	@Column(name="CONTACT_QQ")
	private String contactQq;
	
	/** 微信 */
	@Column(name="CONTACT_WEBCHAT")
	private String contactWebchat;
	
	/** 联系信息状态：0-无效;1-有效 */
	@Column(name="CONTACT_STATUS")
	private Integer contactStatus;
	
	/** 客户 */
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CODE", insertable = true,updatable = true)
	private Customer customer;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getContactLocal() {
		return contactLocal;
	}

	public void setContactLocal(String contactLocal) {
		this.contactLocal = contactLocal;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactZip() {
		return contactZip;
	}

	public void setContactZip(String contactZip) {
		this.contactZip = contactZip;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactQq() {
		return contactQq;
	}

	public void setContactQq(String contactQq) {
		this.contactQq = contactQq;
	}

	public String getContactWebchat() {
		return contactWebchat;
	}

	public void setContactWebchat(String contactWebchat) {
		this.contactWebchat = contactWebchat;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Integer getContactStatus() {
		return contactStatus;
	}

	public void setContactStatus(Integer contactStatus) {
		this.contactStatus = contactStatus;
	}
}