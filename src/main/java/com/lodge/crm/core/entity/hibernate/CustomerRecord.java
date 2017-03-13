package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name="CUSTOMER_RECORD")
public class CustomerRecord implements Serializable{

	private static final long serialVersionUID = 3888712813432156294L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RECORD_ID")
	private Long recordId;

	/** 联系人姓名 */
	@Column(name="RECORD_NAME")
	private String recordName;
	
	@Column(name="RECORD_TYPE")
	private String recordType;
	
	@Column(name="RECORD_TIME")
	private Timestamp recordTime;
	
	@Column(name="RECORD_COMMENT")
	private String recordComment;
	
	@Column(name="RECORD_PHONE")
	private String recordPhone;

	@Column(name="RECORD_ADDRESS")
	private String recordAddress;
	
	@Column(name="RECORD_RESULT")
	private String recordResult;
	@Column(name="RECORD_NTIME")
	private String recordNTime;
	
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "RECORD_CUSTOMER", insertable = true,updatable = true)
	private Customer recordCustomer;
	
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "RECORD_USER", insertable = true,updatable = true)
	private User recordUser;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public Timestamp getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	public String getRecordComment() {
		return recordComment;
	}

	public void setRecordComment(String recordComment) {
		this.recordComment = recordComment;
	}

	public String getRecordPhone() {
		return recordPhone;
	}

	public void setRecordPhone(String recordPhone) {
		this.recordPhone = recordPhone;
	}

	public String getRecordAddress() {
		return recordAddress;
	}

	public void setRecordAddress(String recordAddress) {
		this.recordAddress = recordAddress;
	}

	public String getRecordResult() {
		return recordResult;
	}

	public void setRecordResult(String recordResult) {
		this.recordResult = recordResult;
	}

	public Customer getRecordCustomer() {
		return recordCustomer;
	}

	public void setRecordCustomer(Customer recordCustomer) {
		this.recordCustomer = recordCustomer;
	}

	public User getRecordUser() {
		return recordUser;
	}

	public void setRecordUser(User recordUser) {
		this.recordUser = recordUser;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public String getRecordNTime() {
		return recordNTime;
	}

	public void setRecordNTime(String recordNTime) {
		this.recordNTime = recordNTime;
	}
}
