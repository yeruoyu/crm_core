package com.lodge.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lodge.crm.core.entity.hibernate.StudentHis;

public interface StudentHisRepository extends JpaRepository<StudentHis, Integer>,JpaSpecificationExecutor<StudentHis>{

}
