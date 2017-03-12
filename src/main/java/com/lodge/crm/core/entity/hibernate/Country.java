package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="COUNTRY")
public class Country implements Serializable{

	private static final long serialVersionUID = -5164343750747122985L;

	
	/** 国家代码 */
	@Id
	@Column(name="COUNTRY_CODE")
	@Size(min=2,max=10,message="国家代码必须在2到10之间")
	private String countryCode;
	
	/** 国家名称 */
	@Column(name="COUNTRY_NAME",unique=true)
	@NotNull
	@NotEmpty(message="国家名称不能为空。")
	private String countryName;

	public Country(){
		
	}

	public Country(String countryCode){
		this.countryCode = countryCode;
	}
	
	public Country(String countryCode,String countryName){
		this.countryCode = countryCode;
		this.countryName = countryName;
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
}
