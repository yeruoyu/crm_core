package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role implements Serializable{

	private static final long serialVersionUID = -5342094081305918667L;

	@Id
	@Column(name="ROLE_CODE")
	private String roleCode;
	
	@Column(name="ROLE_NAME")
	private String roleName;
	
	@Column(name="ROLE_STATUS")
	private Integer roleStatus;
	
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@JoinTable(name = "ROLE_USER", 
            joinColumns = @JoinColumn(name = "ROLE_CODE"), 
            inverseJoinColumns = @JoinColumn(name = "USER_CODE"))
	private List<User> userList;
	
	@ManyToMany(mappedBy="roleList",cascade={CascadeType.REMOVE},fetch=FetchType.LAZY)
	private List<Menu> menuList;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

}
