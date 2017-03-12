package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_PROJECT")
public class CustomerProject implements Serializable{

	private static final long serialVersionUID = 7628734010177401708L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CP_ID")
	private Long cpId;
	
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CODE", insertable = true,updatable = true)
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_CODE", insertable = true,updatable = true)
	private Project project;
	
	@Column(name="COMMENTS")
	private String comments;

	public Long getCpId() {
		return cpId;
	}

	public void setCpId(Long cpId) {
		this.cpId = cpId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
