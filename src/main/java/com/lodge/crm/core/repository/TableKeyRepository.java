package com.lodge.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lodge.crm.core.entity.hibernate.TableKey;

public interface TableKeyRepository extends JpaRepository<TableKey, Long>,JpaSpecificationExecutor<TableKey> {
	public TableKey findTableKeyByCode(String code);
}
