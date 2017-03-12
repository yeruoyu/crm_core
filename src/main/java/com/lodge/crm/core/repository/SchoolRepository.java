package com.lodge.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lodge.crm.core.entity.hibernate.School;

/**
 * 学校信息
 * @author Administrator
 *
 */
public interface SchoolRepository extends JpaRepository<School, String>,JpaSpecificationExecutor<School>{

}
