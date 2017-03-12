package com.lodge.crm.core.entity.hibernate;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name="MENU")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MENU_CODE")
	private String menuCode;

	@Column(name="MENU_CSS")
	private String menuCss;

	@Column(name="MENU_ICON")
	private String menuIcon;

	@Column(name="MENU_LEVEL")
	private Integer menuLevel;

	@Column(name="MENU_NAME")
	private String menuName;

	@Column(name="MENU_SORT")
	private Integer menuSort;

	@Column(name="MENU_STATUS")
	private int menuStatus;

	@Column(name="MENU_TYPE")
	private String menuType;

	@Column(name="MENU_URL")
	private String menuUrl;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="MENU_PARCODE")
	private Menu parentMenu;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="parentMenu")
	private List<Menu> menus;

	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinTable(name = "ROLE_MENU", 
            joinColumns = @JoinColumn(name = "MENU_CODE"), 
            inverseJoinColumns = @JoinColumn(name = "ROLE_CODE"))
	private List<Role> roleList;
	
	public Menu() {
	}



	public String getMenuCode() {
		return menuCode;
	}



	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}



	public String getMenuCss() {
		return this.menuCss;
	}

	public void setMenuCss(String menuCss) {
		this.menuCss = menuCss;
	}

	public String getMenuIcon() {
		return this.menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getMenuLevel() {
		return this.menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getMenuSort() {
		return this.menuSort;
	}

	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
	}

	public int getMenuStatus() {
		return this.menuStatus;
	}

	public void setMenuStatus(int menuStatus) {
		this.menuStatus = menuStatus;
	}

	public String getMenuType() {
		return this.menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Menu getParentMenu() {
		return this.parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setParentMenu(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setParentMenu(null);

		return menus;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}