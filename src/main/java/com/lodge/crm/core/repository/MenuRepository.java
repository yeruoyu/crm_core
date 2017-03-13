package com.lodge.crm.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.Menu;

public interface MenuRepository extends JpaRepository<Menu, String>,
		JpaSpecificationExecutor<Menu> {

	@Query("select m from Menu m where m.menuType = ?1 and m.menuStatus=1 order by m.menuSort")
	public List<Menu> findByMenuType(String menuType);

	/**
	 * 根据用户ID 获取用户的菜单
	 * @param userCode
	 * @param menuType
	 * @return
	 */
	@Query("select m from Menu m join m.roleList r "
			+ "join r.userList u "
			+ "where u.userCode = ?1 "
			+ "and m.menuType = ?2 "
			+ "and m.menuStatus=1 "
			+ "and r.roleStatus=1 "
			+ "and u.userStatus=1 "
			+ "order by m.menuSort")
	public List<Menu> findByUserCode(String userCode, String menuType);
	
	@Query("select m from Menu m join m.roleList r "
			+ "where r.roleCode = ?1 "
			+ "and m.menuType = ?2 "
			+ "and m.menuStatus=1 "
			+ "and r.roleStatus=1 "
			+ "order by m.menuSort")
	public List<Menu> findByRoleCode(String roleCode,String menuType);
}
