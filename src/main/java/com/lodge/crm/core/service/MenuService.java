package com.lodge.crm.core.service;

import java.util.List;

import com.lodge.crm.core.entity.hibernate.Menu;

public interface MenuService extends BaseJqGridService<Menu,String> {
	List<Menu> findByMenuType(String menuType);
	
	List<Menu> findByUserCode(String userCode,String menuType);
}
