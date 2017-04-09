package com.lodge.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lodge.crm.core.entity.hibernate.Contract;

public interface ContractRepository extends JpaRepository<Contract, String>,JpaSpecificationExecutor<Contract>{

}
