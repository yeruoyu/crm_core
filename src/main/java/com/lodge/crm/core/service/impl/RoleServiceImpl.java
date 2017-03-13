package com.lodge.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.common.Constants;
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
	public Boolean create(Role entity) {
		Role newRole = roleRepository.saveAndFlush(entity);
		if(newRole == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Role> entities) {
		roleRepository.save(entities);
	}

	@Override
	public Boolean delete(Role entity) {
		roleRepository.delete(entity);
		Role exisitRole = roleRepository.findOne(entity.getRoleCode());
		if(exisitRole !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Role> entities) {
		roleRepository.deleteInBatch(entities);
	}

	@Override
	public Boolean update(Role entity) {
		Role exisitRole = roleRepository.saveAndFlush(entity);
		if(exisitRole == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Role> entities) {
		roleRepository.save(entities);
	}

	@Override
	public List<Role> findAll() {
		List<Role> roles =  roleRepository.findAll();
		for(Role role:roles){
			this.getRoleDetailInfo(role);
		}
		return roles;
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		Page<Role> roles =  roleRepository.findAll(pageable);
		for(Role role:roles){
			this.getRoleDetailInfo(role);
		}
		return roles;
	}
	
	@Override
	public Page<Role> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Role> spec = getWhereClause(jqgridFilter);
		Page<Role> roles = roleRepository.findAll(spec, pageable);
		for(Role role:roles){
			this.getRoleDetailInfo(role);
		}
		return roles;
	}

	private Specification<Role> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Role>() {
        	@Override
			 public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
						if(rule.getOp().equals("eq")){
							predicate.add(cb.equal(root.get(rule.getField()).as(String.class),rule.getData()));
						}
					}
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
        };
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
