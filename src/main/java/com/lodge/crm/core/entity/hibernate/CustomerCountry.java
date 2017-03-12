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
@Table(name="CUSTOMER_COUNTRY")
public class CustomerCountry  implements Serializable{

	private static final long serialVersionUID = 1833994918209568017L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CC_ID")
	private Long ccId;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_CODE", insertable = true,updatable = true)
	private Customer customer;
	
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
}
