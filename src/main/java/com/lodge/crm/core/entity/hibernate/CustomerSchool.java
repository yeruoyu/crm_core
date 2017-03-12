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

/**
 * 客户-学校 对应表
 * @author Administrator
 *
 */
@Entity
@Table(name="CUSTOMER_SCHOOL")
public class CustomerSchool implements Serializable{

	private static final long serialVersionUID = 2674926870006062413L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CS_ID")
	private Long csId;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CODE", insertable = true,updatable = true)
	private Customer customer;
	
	@Column(name="SCHOOL_CODE")
	private String schoolCode;
	
	@Column(name="SCHOOL_NAME")
	private String schoolName;

	public Long getCsId() {
		return csId;
	}

	public void setCsId(Long csId) {
		this.csId = csId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
