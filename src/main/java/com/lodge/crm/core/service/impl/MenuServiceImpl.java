package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.Menu;
import com.lodge.crm.core.repository.MenuRepository;
import com.lodge.crm.core.service.MenuService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuRepository menuRepository;

	@Override
	public Boolean create(Menu entity) {
		Menu newMenu = menuRepository.saveAndFlush(entity);
		if(newMenu ==null){
			return false;
		}
		return true;
	}

	@Override
	public Boolean update(Menu entity) {
		Menu newMenu = menuRepository.saveAndFlush(entity);
		if(newMenu ==null){
			return false;
		}
		return true;
	}

	@Override
	public Boolean delete(Menu entity) {
		menuRepository.delete(entity);
		Menu newMenu = menuRepository.findOne(entity.getMenuCode());
		if(newMenu != null){
			return false;
		}
		return true;
	}

	@Override
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}
	
	@Override
	public Menu findOne(String code){
		return menuRepository.getOne(code);
	}

	@Override
	public void creatInBatch(Iterable<Menu> entities) {
		this.menuRepository.save(entities);
	}

	@Override
	public void deleteInBatch(Iterable<Menu> entities) {
		this.menuRepository.deleteInBatch(entities);
	}

	@Override
	public void updateInBatch(Iterable<Menu> entities) {
		this.menuRepository.save(entities);
	}

	@Override
	public Page<Menu> findAll(Pageable pageable) {
		return this.menuRepository.findAll(pageable);
	}
	
	@Override
	public List<Menu> findByMenuType(String menuType){
		return this.menuRepository.findByMenuType(menuType);
	}
	
	@Override
	public List<Menu> findByUserCode(String userCode,String menuType){
		List<Menu> menuList = this.menuRepository.findByUserCode(userCode, menuType);
		return menuList;
	}
	
	@Override
	public Page<Menu> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
