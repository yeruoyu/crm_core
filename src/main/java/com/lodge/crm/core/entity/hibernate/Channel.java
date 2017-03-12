package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CHANNEL")
public class Channel  implements Serializable{

	private static final long serialVersionUID = 4423887344848868966L;

	@Id
	@Column(name="CHANNEL_CODE")
	private String channelCode;
	
	@Column(name="CHANNEL_NAME")
	private String channelName;
	
	@Column(name="CHANNEL_COMPANY")
	private String channelCompany;
	
	@Column(name="CHANNEL_ADDRESS")
	private String channelAddress;
	
	@Column(name="CONTACT1_NAME")
	private String contact1Name;
	
	@Column(name="CONTACT1_PHONE")
	private String contact1Phone;
	
	@Column(name="CONTACT1_MOBILE")
	private String contact1Mobile;
	
	@Column(name="CONTACT1_EMAIL")
	private String contact1Email;
	
	@Column(name="CONTACT1_QQ")
	private String contact1QQ;
	
	@Column(name="CONTACT1_WEBCHAT")
	private String contact1Webchat;
	
	@Column(name="CONTACT2_NAME")
	private String contact2Name;
	
	@Column(name="CONTACT2_PHONE")
	private String contact2Phone;
	
	@Column(name="CONTACT2_MOBILE")
	private String contact2Mobile;
	
	@Column(name="CONTACT2_EMAIL")
	private String contact2Email;
	
	@Column(name="CONTACT2_QQ")
	private String contact2QQ;
	
	@Column(name="CONTACT2_WEBCHAT")
	private String contact2Webchat;
	
	@Column(name="CHANNEL_COMMENTS")
	private String channelComments;

	@OneToMany(mappedBy ="channel",fetch=FetchType.LAZY )
	private List<Customer> customerList;

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelCompany() {
		return channelCompany;
	}

	public void setChannelCompany(String channelCompany) {
		this.channelCompany = channelCompany;
	}

	public String getChannelAddress() {
		return channelAddress;
	}

	public void setChannelAddress(String channelAddress) {
		this.channelAddress = channelAddress;
	}

	public String getContact1Name() {
		return contact1Name;
	}

	public void setContact1Name(String contact1Name) {
		this.contact1Name = contact1Name;
	}

	public String getContact1Phone() {
		return contact1Phone;
	}

	public void setContact1Phone(String contact1Phone) {
		this.contact1Phone = contact1Phone;
	}

	public String getContact1Mobile() {
		return contact1Mobile;
	}

	public void setContact1Mobile(String contact1Mobile) {
		this.contact1Mobile = contact1Mobile;
	}

	public String getContact1Email() {
		return contact1Email;
	}

	public void setContact1Email(String contact1Email) {
		this.contact1Email = contact1Email;
	}

	public String getContact1QQ() {
		return contact1QQ;
	}

	public void setContact1QQ(String contact1qq) {
		contact1QQ = contact1qq;
	}

	public String getContact1Webchat() {
		return contact1Webchat;
	}

	public void setContact1Webchat(String contact1Webchat) {
		this.contact1Webchat = contact1Webchat;
	}

	public String getContact2Name() {
		return contact2Name;
	}

	public void setContact2Name(String contact2Name) {
		this.contact2Name = contact2Name;
	}

	public String getContact2Phone() {
		return contact2Phone;
	}

	public void setContact2Phone(String contact2Phone) {
		this.contact2Phone = contact2Phone;
	}

	public String getContact2Mobile() {
		return contact2Mobile;
	}

	public void setContact2Mobile(String contact2Mobile) {
		this.contact2Mobile = contact2Mobile;
	}

	public String getContact2Email() {
		return contact2Email;
	}

	public void setContact2Email(String contact2Email) {
		this.contact2Email = contact2Email;
	}

	public String getContact2QQ() {
		return contact2QQ;
	}

	public void setContact2QQ(String contact2qq) {
		contact2QQ = contact2qq;
	}

	public String getContact2Webchat() {
		return contact2Webchat;
	}

	public void setContact2Webchat(String contact2Webchat) {
		this.contact2Webchat = contact2Webchat;
	}

	public String getChannelComments() {
		return channelComments;
	}

	public void setChannelComments(String channelComments) {
		this.channelComments = channelComments;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
}
