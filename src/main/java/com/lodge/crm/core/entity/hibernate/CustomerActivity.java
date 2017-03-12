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
 * 客户-活动对应表
 * @author Administrator
 *
 */
@Entity
@Table(name="CUSTOMER_ACTIVITY")
public class CustomerActivity implements Serializable{

	private static final long serialVersionUID = -96911189144131075L;

	/** 主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CA_ID")
	private Long caId;
	
	/** 客户信息 */
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CODE", insertable = true,updatable = true)
	private Customer customer;
	
	/** 活动信息 */
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "ACTIVITY_CODE", insertable = true,updatable = true)
	private Activity activity;
	
	/** 是否出席:0-未出席;1-已出席 */
	@Column(name="ATTEND_STATUS")
	private Integer AttendStatus;
	
	/** 备注 */
	@Column(name="COMMENTS")
	private String comments;

	public Long getCaId() {
		return caId;
	}

	public void setCaId(Long caId) {
		this.caId = caId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Integer getAttendStatus() {
		return AttendStatus;
	}

	public void setAttendStatus(Integer attendStatus) {
		AttendStatus = attendStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
