package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
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
 * 合约信息表
 * @author schindler
 *
 */
@Entity
@Table(name="CONTRACT")
public class Contract  implements Serializable{

	private static final long serialVersionUID = 5886926938391995102L;
	
	/** 合约代码,主键 */
	@Id
	@Column(name="CONTRACT_CODE")
	private String contractCode;
	
	/** 签约学生 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTRACT_STUDENT", insertable = true,updatable = true)
	private Student student;
	
	/** 签约客户 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTRACT_CUSTOMER", insertable = true,updatable = true)
	private Customer customer;
	
	/** 签约课程 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTRACT_COURSE", insertable = true,updatable = true)
	private Course course;
	
	/** 合约负责人 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTRACT_USER", insertable = true,updatable = true)
	private User user;
	
	/** 签约日期 */
	@Column(name="CONTRACT_DATE")
	private Date contractDate;

	/** 合约价格 */
	@Column(name="CONTRACT_PRICE")
	private Double contractPrice;
	
	/** 合约折扣 */
	@Column(name="CONTRACT_DISCOUNT")
	private Double contractDiscount;
	
	/** 合约金额 */
	@Column(name="CONTRACT_AMOUNT")
	private Double contractAmount;

	/** 合约订金 */
	@Column(name="CONTRACT_DEPOSIT")
	private Double contractDeposit;

	/** 付费形式(全额、定金+余额) */
	@Column(name="CONTRACT_PAYFORM")
	private Integer payForm;
	
	/** 支付状态 */
	@Column(name="CONTRACT_PAIDSTATUS")
	private Integer paidStatus;
	
	/** 开票状态 */
	@Column(name="CONTRACT_BILLSTATUS")
	private Integer billStatus;
	
	/** 发票号码 */
	@Column(name="CONTRACT_BILLNO")
	private String billNo;
	
	/** 发票号码 */
	@Column(name="CONTRACT_BILLDATE")
	private Date billDate;	
	
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
	
	/** 合约对应的金额记录 */
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "contract",fetch=FetchType.LAZY )
	private List<CourseAmount> amountList;

}
