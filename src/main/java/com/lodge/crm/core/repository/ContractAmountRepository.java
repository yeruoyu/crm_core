package com.lodge.crm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lodge.crm.core.entity.hibernate.ContractAmount;

public interface ContractAmountRepository extends JpaRepository<ContractAmount, String>,JpaSpecificationExecutor<ContractAmount>{

}
