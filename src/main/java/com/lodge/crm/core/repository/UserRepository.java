package com.lodge.crm.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.lodge.crm.core.entity.hibernate.User;

public interface UserRepository extends JpaRepository<User, String>,JpaSpecificationExecutor<User> {
	
	@Query(value="SELECT u FROM User u Where u.userEmail like ?1")
	public List<User> findbyEmailAccount(String emailCount);

}
