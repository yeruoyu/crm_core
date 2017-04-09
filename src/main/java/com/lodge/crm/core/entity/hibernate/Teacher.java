package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 教师信息表
 * @author schindler
 *
 */
@Entity
@Table(name="TEACHER")
public class Teacher implements Serializable{

	private static final long serialVersionUID = -5394421375113661523L;

	/** 教师代码,主键 */
	@Id
	@Column(name="TEACHER_CODE")
	private String teacherCode;
	
	/** 教师姓名 */
	@Column(name="TEACHER_NAME")
	private String teacherName;
	
	/** 教师性别 */
	@Column(name="TEACHER_SEX")
	private Integer sex;
	
	/** 教师学历 */
	@Column(name="TEACHER_EDUCATION")
	private String education;
	
	/** 毕业学校 */
	@Column(name="TEACHER_SCHOOLNAME")
	private String schoolName;
	
	/** 教师专业 */
	@Column(name="TEACHER_MAJOR")
	private String major;
	
	/** 授课形式(兼职/全职) */
	@Column(name="TEACHING_FORM")
	private Integer teachingForm;
	
	/** 对应课程 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEACHING_COURSE", insertable = true,updatable = true)
	private Course course;
	
	/** 教师简介 */
	@Column(name="TEACHER_INTRODUCE")
	private String introduce;

	/** 教师状态 */
	@Column(name="TEACHER_STATUS")
	private Integer status;
	
	/** 创建用户 */
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

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getTeachingForm() {
		return teachingForm;
	}

	public void setTeachingForm(Integer teachingForm) {
		this.teachingForm = teachingForm;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
