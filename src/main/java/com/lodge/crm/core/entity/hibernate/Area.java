package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AREA")
public class Area implements Serializable {

	private static final long serialVersionUID = 2234171271327291921L;

	@Id
	@Column(name="AREA_CODE")
	private String areaCode;
	
	@Column(name="AREA_NAME")
	private String areaName;
	
	@Column(name="CITY_NAME")
	private String cityName;	
	
	@Column(name="COUNTY_NAME")
	private String countryName;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}	
	
	
}
