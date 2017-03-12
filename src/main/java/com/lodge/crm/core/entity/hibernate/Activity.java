package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 活动信息表
 * @author Administrator
 *
 */
@Entity
@Table(name="ACTIVITY")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 活动代码,主键 */
	@Id
	@Column(name="ACTIVITY_CODE")
	private String activityCode;
	
	/** 活动标题 */
	@Column(name="ACTIVITY_TITLE")
	private String activityTitle;
	
	/** 活动说明 */
	@Column(name="ACTIVITY_DESC")
	private String activityDesc;
	
	/** 活动人数 */
	@Column(name="ACTIVITY_ACCOUNT")
	private int activityAccount;

	/** 活动地址 */
	@Column(name="ACTIVITY_ADDRESS")
	private String activityAddress;

	/** 活动开始时间 */
	@Column(name="ACTIVITY_START_DATE")
	private Timestamp activityStartDate;

	/** 活动结束时间 */
	@Column(name="ACTIVITY_STOP_DATE")
	private Timestamp activityStopDate;


	/** 活动状态，0-未开始;1-进行中;2-已结束;9-已删除 */
	@Column(name="ACTIVITY_STATUS")
	private int activityStatus;

	public Activity() {
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public int getActivityAccount() {
		return this.activityAccount;
	}

	public void setActivityAccount(int activityAccount) {
		this.activityAccount = activityAccount;
	}

	public String getActivityAddress() {
		return this.activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public Timestamp getActivityStartDate() {
		return activityStartDate;
	}

	public void setActivityStartDate(Timestamp activityStartDate) {
		this.activityStartDate = activityStartDate;
	}

	public Timestamp getActivityStopDate() {
		return activityStopDate;
	}

	public void setActivityStopDate(Timestamp activityStopDate) {
		this.activityStopDate = activityStopDate;
	}

	public String getActivityDesc() {
		return this.activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	public int getActivityStatus() {
		return this.activityStatus;
	}

	public void setActivityStatus(int activityStatus) {
		this.activityStatus = activityStatus;
	}

	public String getActivityTitle() {
		return this.activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}
}