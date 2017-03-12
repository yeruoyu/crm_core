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
@Table(name = "OPERATE_LOG")
public class OperateLog implements Serializable {

	private static final long serialVersionUID = 766994872762868256L;

	/** 主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOG_ID")
	private Long logId;

	/** 操作类型 */
	@Column(name = "OPERATE_TYPE")
	private String operateType;

	/** 操作方法 */
	@Column(name = "OPERATE_METHOD")
	private String operateMethod;

	/** 操作内容 */
	@Column(name = "OPERATE_COMMENT")
	private String operateComment;

	/** 操作员工 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "OPERATE_USER", insertable = true, updatable = true)
	private User logUser;

	/** 操作时间 */
	@Column(name = "OPERATE_TIME")
	private Timestamp operateTime;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Timestamp getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getOperateMethod() {
		return operateMethod;
	}

	public void setOperateMethod(String operateMethod) {
		this.operateMethod = operateMethod;
	}

	public String getOperateComment() {
		return operateComment;
	}

	public void setOperateComment(String operateComment) {
		this.operateComment = operateComment;
	}

	public User getLogUser() {
		return logUser;
	}

	public void setLogUser(User logUser) {
		this.logUser = logUser;
	}
}
