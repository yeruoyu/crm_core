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

/**
 * 客户所对应的合同
 * @author Administrator
 *
 */
@Entity
@Table(name = "CUSTOMER_CONTRACT")
public class CustomerContract implements Serializable {

	private static final long serialVersionUID = -7993025171639413483L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CC_ID")
	private Long ccId;

	/** 客户代码 */
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CODE", insertable = true,updatable = true)
	private Customer customer;

	/** 合同代码 */
	@Column(name="CONTRACT_CODE")
	private String contractCode;

	/** 备注 */
	@Column(name="COMMENTS")
	private String comments;

	/** 合同签订时间  */
	@Column(name="SINGED_TIME")
	private Timestamp signedTime;

	public Long getCcId() {
		return ccId;
	}

	public void setCcId(Long ccId) {
		this.ccId = ccId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getSignedTime() {
		return signedTime;
	}

	public void setSignedTime(Timestamp signedTime) {
		this.signedTime = signedTime;
	}
}
