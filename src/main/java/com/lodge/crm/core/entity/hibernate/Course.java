package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course  implements Serializable{

	private static final long serialVersionUID = -6233630147709065485L;
	
	/** 课程代码,主键 */
	@Id
	@Column(name="COURSE_CODE")
	private String courseCode;
	
	/** 课程名称 */
	@Column(name="COURSE_NAME")
	private String courseName;
	
	/** 课程说明 */
	@Column(name="COURSE_DESCRIPTION")
	private String courseDescription;
	
	/** 课程状态 */
	@Column(name="COURSE_STATUS")
	private Integer courseStatus;
}
