package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.Role;
import com.lodge.crm.core.repository.RoleRepository;
import com.lodge.crm.core.service.RoleService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Page<Role> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatInBatch(Iterable<Role> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Role> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(Role entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<Role> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findOne(String code) {
		Role role = roleRepository.findOne(code);
        if(role == null) {
            return null;
        }
        this.getRoleDetailInfo(role);
        return role;
	}
	
	private void getRoleDetailInfo(Role role){
		role.getMenuList().size();
	}

}
