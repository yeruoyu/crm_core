package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DIST_INFO")
public class DistInfo implements Serializable {

	private static final long serialVersionUID = 7470704542817936509L;
	/** 数据字典ID */
	@Id
	@Column(name="DIST_ID")
	private Integer distId;
	/** 数据字典类型 */
	@Column(name="DIST_TYPE")
	private String distType;
	
	/** 数据字典代码 */
	@Column(name="DIST_CODE")
	private String distCode;
	
	/** 数据字典值 */
	@Column(name="DIST_VALUE")
	private String distValue;
	
	/** 数据字典说明 */
	@Column(name="DIST_REMARK")
	private String distRemark;

	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distId) {
		this.distId = distId;
	}

	public String getDistType() {
		return distType;
	}

	public void setDistType(String distType) {
		this.distType = distType;
	}

	public String getDistValue() {
		return distValue;
	}

	public void setDistValue(String distValue) {
		this.distValue = distValue;
	}

	public String getDistRemark() {
		return distRemark;
	}

	public void setDistRemark(String distRemark) {
		this.distRemark = distRemark;
	}

	public String getDistCode() {
		return distCode;
	}

	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}
}
