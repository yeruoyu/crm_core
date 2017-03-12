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
 * 公告对象
 * @author schindler
 *
 */
@Entity
@Table(name="PUBLISH")
public class Publish  implements Serializable{

	private static final long serialVersionUID = -1418117321344786495L;

	/** 公告ID 主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PUBLISH_ID")
	private Integer publishId;
	
	/** 公告标题 */
	@Column(name="PUBLISH_TITLE")
	private String publishTitle;
	
	/** 公告内容 */
	@Column(name="PUBLISH_DETAIL")
	private String publishDetail;
	
	/** 公告状态 */
	@Column(name="PUBLISH_STATUS")
	private Integer publishStatus;
	
	/** 公告创建人 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PUBLISH_CUSER", insertable = true,updatable = true)
	private User publishCUser;
	
	/** 公告修改人 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PUBLISH_UUSER", insertable = true,updatable = true)
	private User publishUUser;
	
	/** 公告创建时间 */
	@Column(name="PUBLISH_CTIME")
	private Date publishCTime;
	
	/** 公告修改时间 */
	@Column(name="PUBLISH_UTIME")
	private Date publishUTime;

	public Integer getPublishId() {
		return publishId;
	}

	public void setPublishId(Integer publishId) {
		this.publishId = publishId;
	}

	public String getPublishTitle() {
		return publishTitle;
	}

	public void setPublishTitle(String publishTitle) {
		this.publishTitle = publishTitle;
	}

	public String getPublishDetail() {
		return publishDetail;
	}

	public void setPublishDetail(String publishDetail) {
		this.publishDetail = publishDetail;
	}

	public Integer getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}

	public User getPublishCUser() {
		return publishCUser;
	}

	public void setPublishCUser(User publishCUser) {
		this.publishCUser = publishCUser;
	}

	public User getPublishUUser() {
		return publishUUser;
	}

	public void setPublishUUser(User publishUUser) {
		this.publishUUser = publishUUser;
	}

	public Date getPublishCTime() {
		return publishCTime;
	}

	public void setPublishCTime(Date publishCTime) {
		this.publishCTime = publishCTime;
	}

	public Date getPublishUTime() {
		return publishUTime;
	}

	public void setPublishUTime(Date publishUTime) {
		this.publishUTime = publishUTime;
	}
}
