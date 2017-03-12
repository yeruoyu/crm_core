package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SCHOOL")
public class School implements Serializable {
	private static final long serialVersionUID = -4978859309851980315L;

	/** 学校代码,主键 */
	@Id
	@Column(name = "SCHOOL_CODE")
	private String schoolCode;

	/** 学校关键字 */
	@Column(name = "SCHOOL_KEYWORD")
	private String schoolKeyword;

	/** 学校名称 */
	@NotNull
	@Column(name = "SCHOOL_NAME")
	private String schoolName;

	/** 学校说明 */
	@Column(name = "SCHOOL_COMMENTS")
	private String schoolComments;

	/** 学校状态：0-禁用;1-正常 */
	@Column(name = "SCHOOL_STATUS")
	private Integer schoolStatus;

	/** 学校对应的项目 */
	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Project> projectSet;

	/** 对应的客户 */
	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Customer> customerSet;
	
	/** 对应的员工 */
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinTable(name = "USER_SCHOOL", 
    joinColumns = @JoinColumn(name = "SCHOOL_CODE"), 
    inverseJoinColumns = @JoinColumn(name = "USER_CODE"))
	private List<User> userList;

	public School() {

	}

	public School(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public School(String schoolCode, String schoolName) {
		this.schoolCode = schoolCode;
		this.schoolName = schoolName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Set<Project> getProjectSet() {
		return projectSet;
	}

	public void setProjectSet(Set<Project> projectSet) {
		this.projectSet = projectSet;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolComments() {
		return schoolComments;
	}

	public void setSchoolComments(String schoolComments) {
		this.schoolComments = schoolComments;
	}

	public Integer getSchoolStatus() {
		return schoolStatus;
	}

	public void setSchoolStatus(Integer schoolStatus) {
		this.schoolStatus = schoolStatus;
	}

	public Set<Customer> getCustomerSet() {
		return customerSet;
	}

	public void setCustomerSet(Set<Customer> customerSet) {
		this.customerSet = customerSet;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getSchoolKeyword() {
		return schoolKeyword;
	}

	public void setSchoolKeyword(String schoolKeyword) {
		this.schoolKeyword = schoolKeyword;
	}
}
