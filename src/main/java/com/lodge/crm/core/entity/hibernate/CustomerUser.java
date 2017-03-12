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
@Table(name="CUSTOMER_USER")
public class CustomerUser implements Serializable {

	private static final long serialVersionUID = -2324539938918378653L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CU_ID")
	private Long cuId;
	
	@Column(name="LOCK_STATUS")
	private Integer lockStatus;
	
	@Column(name="LOCK_DATE")
	private Timestamp lockDate;
	
	@Column(name="UNLOCK_DATE")
	private Timestamp unlockDate;
	
	@Column(name="UNLOCK_COMMENT")
	private String unlockComment;
	
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_CODE", insertable = true,updatable = true)
	private User lockUser;
	
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CODE", insertable = true,updatable = true)
	private Customer lockCustomer;

	public Long getCuId() {
		return cuId;
	}

	public void setCuId(Long cuId) {
		this.cuId = cuId;
	}

	public Integer getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(Integer lockStatus) {
		this.lockStatus = lockStatus;
	}

	public Timestamp getLockDate() {
		return lockDate;
	}

	public void setLockDate(Timestamp lockDate) {
		this.lockDate = lockDate;
	}

	public Timestamp getUnlockDate() {
		return unlockDate;
	}

	public void setUnlockDate(Timestamp unlockDate) {
		this.unlockDate = unlockDate;
	}

	public String getUnlockComment() {
		return unlockComment;
	}

	public void setUnlockComment(String unlockComment) {
		this.unlockComment = unlockComment;
	}

	public User getLockUser() {
		return lockUser;
	}

	public void setLockUser(User lockUser) {
		this.lockUser = lockUser;
	}

	public Customer getLockCustomer() {
		return lockCustomer;
	}

	public void setLockCustomer(Customer lockCustomer) {
		this.lockCustomer = lockCustomer;
	}
}
