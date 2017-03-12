package com.lodge.crm.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.entity.hibernate.Project;
import com.lodge.crm.core.entity.hibernate.School;

public interface ProjectService extends BaseJqGridService<Project,String>{
	/**
	 * 根据项目名称分页模糊查询
	 * @param projectName
	 * @param pageRequest
	 * @return
	 */
	public Page<Project> findByProjectName(String projectName,Pageable pageRequest);

	/**
	 * 根据学校ID 查询项目
	 * @param school
	 * @return
	 */
	public Page<Project> findBySchool(School school,Pageable pageable);
	
	/**
	 * 获取所有有效的项目
	 * @return
	 */
	public List<Project> findEnableProject();

}
