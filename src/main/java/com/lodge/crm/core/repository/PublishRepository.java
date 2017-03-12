package com.lodge.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lodge.crm.core.entity.hibernate.Publish;
import com.lodge.crm.core.entity.hibernate.Schedule;

public interface PublishRepository  extends JpaRepository<Publish, Integer>,JpaSpecificationExecutor<Publish>{

}
