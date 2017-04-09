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
 * 学生信息表
 * @author schindler
 *
 */
@Entity
@Table(name="STUDENT")
public class Student implements Serializable{

	private static final long serialVersionUID = -4130715627272462789L;
	/** 学生代码,主键 */
	@Id
	@Column(name="STUDENT_CODE")
	private String studentCode;
	
	/** 学生姓名 */
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	/** 学生性别 */
	@Column(name="STUDENT_SEX")
	private Integer studentSex;
	
	/** 学生年龄 */
	@Column(name="STUDENT_AGE")
	private Integer studentAge;
	
	/** 学生专业 */
	@Column(name="STUDENT_MAJOR")
	private String studentMajor;
	
	/** 学生最高学历 */
	@Column(name="STUDENT_EDUCATION")
	private String studentEducation;
	
	/** 学生毕业学校 */
	@Column(name="STUDENT_SCHOOLNAME")
	private String studentSchool;
	
	/** 学生状态 */
	@Column(name="STUDENT_STATUS")
	private Integer studentStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STUDENT_COURSE", insertable = true,updatable = true)
	private Course studentCourse;
	
	/** 学生对应的客户 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STUDENT_CUSTOMER", insertable = true,updatable = true)
	private Customer studentCustomer;
	
	/** 学生负责人 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STUDENT_USER", insertable = true,updatable = true)
	private User user;
	
	/** 创建用户Code */
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
}
