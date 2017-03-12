package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.util.Date;

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
 * 日程表
 * @author Administrator
 *
 */
@Entity
@Table(name="SCHEDULE")
public class Schedule implements Serializable{

	private static final long serialVersionUID = -1418117321344786495L;

	/** 日程ID 主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SCHEDULE_ID")
	private Integer scheduleId;
	
	/** 日程对应用户ID */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCHEDULE_USER", insertable = true,updatable = true)
	private User scheduleUser;
	
	/** 日程类型 */
	@Column(name="SCHEDULE_TYPE")
	private String scheduleType;
	
	/** 日程标题 */
	@Column(name="SCHEDULE_TITLE")
	private String scheduleTitle;
	
	/** 日程详细信息 */
	@Column(name="SCHEDULE_DETAIL")
	private String scheduleDetail;
	
	/** 日程开始时间 */
	@Column(name="SCHEDULE_STARTTIME")
	private Date scheduleStartTime;
	
	/** 日程结束时间 */
	@Column(name="SCHEDULE_ENDTIME")
	private Date scheduleEndTime;
	
	/** 日程状态 */
	@Column(name="SCHEDULE_STATUS")
	private Integer scheduleStatus;
	
	/** 创建日程的员工 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCHEDULE_CREATOR", insertable = true,updatable = true)
	private User createUser;

	/** 日程创建时间 */
	@Column(name="SCHEDULE_CREATETIME")
	private Date createTime;

	/** 日程指派ID */
	@Column(name="SCHEDULE_PID")
	private Integer schedulePid;
	
	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public String getScheduleDetail() {
		return scheduleDetail;
	}

	public void setScheduleDetail(String scheduleDetail) {
		this.scheduleDetail = scheduleDetail;
	}

	public Date getScheduleStartTime() {
		return scheduleStartTime;
	}

	public void setScheduleStartTime(Date scheduleStartTime) {
		this.scheduleStartTime = scheduleStartTime;
	}

	public Date getScheduleEndTime() {
		return scheduleEndTime;
	}

	public void setScheduleEndTime(Date scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}

	public Integer getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(Integer scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	public User getScheduleUser() {
		return scheduleUser;
	}

	public void setScheduleUser(User scheduleUser) {
		this.scheduleUser = scheduleUser;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getSchedulePid() {
		return schedulePid;
	}

	public void setSchedulePid(Integer schedulePid) {
		this.schedulePid = schedulePid;
	}
}
