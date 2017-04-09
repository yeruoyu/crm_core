package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 合约金额对应表
 * @author schindler
 *
 */
@Entity
@Table(name="CONTRACT_AMOUNT")
public class ContractAmount implements Serializable{

	private static final long serialVersionUID = -1018324450164405201L;
	
	/** 合约金额Code 主键 */
	@Id
	@Column(name="AMOUNT_CODE")
	private String amountCode;
	
	/** 对应合约 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTRACT_CODE", insertable = true,updatable = true)
	private Contract contract;
	
	/** 金额说明 */
	@Column(name="AMOUNT_DESCRIPTION")
	private String amountDesc;
	
	/** 付费方式(现金、转账、POS、微信、支付宝) */
	@Column(name="AMOUNT_PAYMETHOD")
	private Integer payMethod;
		
	/** 合约应付金额 */
	@Column(name="AMOUNT_PAYABLE")
	private Double amountPayable;
	
	/** 合约实付金额 */
	@Column(name="AMOUNT_REALPAY")
	private Double amountRealpay;
	
	/** 预计支付日期 */
	@Column(name="AMOUNT_ESTIMATEDATE")
	private Date estimateDate;
	
	/** 实际支付日期 */
	@Column(name="AMOUNT_REALDATE")
	private Date reayPayDate;
	
	/** 支付人 */
	@Column(name="AMOUNT_PAYUSER")
	private String payUser;
	
	/** 收款人 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AMOUNT_RECEIVER", insertable = true,updatable = true)
	private User receiver;
	
	/** 支付账号*/
	@Column(name="AMOUNT_ACCOUNT")
	private String payAccount;
	
	/** 创建用户Code */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CREATE_USER", insertable = true,updatable = true)
	private User creatUser;

	/** 创建时间 */
	@Column(name="CREATE_TIME")
	private Timestamp createTime;
	
	/** 修改用户 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UPDATE_USER", insertable = true,updatable = true)
	private User updateUser;
	
	/** 修改时间 */
	@Column(name="UPDATE_TIME")
	private Timestamp updateTime;

	public String getAmountCode() {
		return amountCode;
	}

	public void setAmountCode(String amountCode) {
		this.amountCode = amountCode;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getAmountDesc() {
		return amountDesc;
	}

	public void setAmountDesc(String amountDesc) {
		this.amountDesc = amountDesc;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Double getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(Double amountPayable) {
		this.amountPayable = amountPayable;
	}

	public Double getAmountRealpay() {
		return amountRealpay;
	}

	public void setAmountRealpay(Double amountRealpay) {
		this.amountRealpay = amountRealpay;
	}

	public Date getEstimateDate() {
		return estimateDate;
	}

	public void setEstimateDate(Date estimateDate) {
		this.estimateDate = estimateDate;
	}

	public Date getReayPayDate() {
		return reayPayDate;
	}

	public void setReayPayDate(Date reayPayDate) {
		this.reayPayDate = reayPayDate;
	}

	public String getPayUser() {
		return payUser;
	}

	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public User getCreatUser() {
		return creatUser;
	}

	public void setCreatUser(User creatUser) {
		this.creatUser = creatUser;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
