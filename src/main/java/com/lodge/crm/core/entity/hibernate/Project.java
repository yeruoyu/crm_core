package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 项目信息
 * @author Administrator
 *
 */
@Entity
@Table(name="PROJECT")
public class Project implements Serializable{

	private static final long serialVersionUID = 4182858377068441377L;

	/** 项目编号 */
	@Id
	@Column(name="PROJECT_CODE",unique=true)
	@NotNull
	@Size(min=1,max=10,message="项目编号不能超过10位。")
	@NotEmpty(message="项目编号不能为空。")
	private String projectCode;
	
	/** 项目名称 */
	@Column(name="PROJECT_NAME")
	@NotNull
	@Size(min=1,max=32,message="项目名称不能超过32位。")
	@NotEmpty(message="项目名称不能为空。")
	private String projectName;
	
	/** 项目说明 */
	@Column(name="PROJECT_DESC")
	@NotNull
	@Size(min=1,max=32,message="项目说明不能超过200位。")
	@NotEmpty(message="项目说明不能为空。")
	private String projectDesc;
	
	/** 项目状态 */
	@Column(name="PROJECT_STATUS")
	@NotNull
	private Integer projectStatus;
	
	/** 项目费用 */
	@NotNull
	@Column(name="PROJECT_PRICE")
	private Double projectPrice;
	
	/** 项目停止时间 */
	@Column(name="STOP_DATE")
	private Date stopDate;
	
	/** 项目开始时间 */
	@Column(name="START_DATE")
	private Date startDate;
	
	/** 项目对应国家 */
    @Column(name = "COUNTRY_NAME")
	private String countryName;

	/** 项目对应学校 */
    @JoinColumn(name = "SCHOOL_CODE", referencedColumnName = "SCHOOL_CODE")
    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity=School.class)
    private School school;
    
    /** 项目对应的客户 */
    @OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade={CascadeType.REFRESH})
    private List<CustomerProject> custProjectList;  
    
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}


	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Double getProjectPrice() {
		return projectPrice;
	}

	public void setProjectPrice(Double projectPrice) {
		this.projectPrice = projectPrice;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
