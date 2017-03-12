package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TABLE_KEY")
public class TableKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4790478972451095399L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="KEY_ID")
	private Long id;
	
	@Column(name="KEY_CODE")
	private String code;
	
	@Column(name="KEY_MAX")
	private Integer max;
	
	@Column(name="KEY_LENGTH")
	private Integer length;
	
	@Column(name="KEY_TABLE")
	private String tableName;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
