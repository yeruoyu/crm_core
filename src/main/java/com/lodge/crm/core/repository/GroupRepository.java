package com.lodge.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lodge.crm.core.entity.hibernate.Group;

public interface GroupRepository  extends JpaRepository<Group, String>,
JpaSpecificationExecutor<Group>{

}
