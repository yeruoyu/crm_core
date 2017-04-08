package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
