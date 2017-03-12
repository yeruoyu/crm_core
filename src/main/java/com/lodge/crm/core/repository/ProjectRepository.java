package com.lodge.crm.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.Project;
import com.lodge.crm.core.entity.hibernate.School;

/**
 * Project Repository
 * @author Administrator
 *
 */
public interface ProjectRepository extends JpaRepository<Project, String>,JpaSpecificationExecutor<Project>{
	/**
	 * 根据项目名称模糊查询项目
	 * @param projectName 项目名称
	 * @param pageable 分页
	 * @return
	 */
	public Page<Project> findByProjectNameLike(String projectName,Pageable pageable);
	
	/**
	 * 根据学校查询项目
	 * @param school
	 * @return
	 */
	public Page<Project> findBySchool(School school,Pageable pageable);
	
	@Query(value="SELECT p FROM Project p WHERE p.projectStatus=1 AND p.stopDate>= ?")
	public List<Project> findEnableProject(Date currentDate);
	
}
