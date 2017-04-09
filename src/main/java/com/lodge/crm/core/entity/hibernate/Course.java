package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	/** 课程内容 */
	@Column(name="COURSE_CONTENT")
	private String courseContent;
	
	/** 课程备注 */
	@Column(name="COURSE_REMARK")
	private String courseRemark;
	
	/** 课程课时数 */
	@Column(name="COURSE_HOUR")
	private Integer courseHour;
	
	/** 课程价格 */
	@Column(name="COURSE_PRICE")
	private String coursePrice;

	/** 课程状态 */
	@Column(name="COURSE_STATUS")
	private Double courseStatus;
	
	/** 课程对应的学生记录 */
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "studentCourse",fetch=FetchType.LAZY )
	private List<Student> studentList;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	public String getCourseRemark() {
		return courseRemark;
	}

	public void setCourseRemark(String courseRemark) {
		this.courseRemark = courseRemark;
	}

	public Integer getCourseHour() {
		return courseHour;
	}

	public void setCourseHour(Integer courseHour) {
		this.courseHour = courseHour;
	}

	public String getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Double getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(Double courseStatus) {
		this.courseStatus = courseStatus;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
