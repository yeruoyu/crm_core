package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TEACHER")
public class Teacher implements Serializable{

	private static final long serialVersionUID = -5394421375113661523L;

	/** 教师代码,主键 */
	@Id
	@Column(name="TEACHER_CODE")
	private String teacherCode;
	
	/** 教师姓名 */
	@Column(name="TEACHER_CODE")
	private String teacherName;
	
	/** 教师性别 */
	@Column(name="TEACHER_SEX")
	private String sex;
	
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
	private String teachingForm;
	
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
		
}
