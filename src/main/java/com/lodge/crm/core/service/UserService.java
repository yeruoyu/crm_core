package com.lodge.crm.core.service;

import com.lodge.crm.core.entity.hibernate.User;

public interface UserService extends BaseJqGridService<User,String> {
	User findbyEmailAccount(String emailCount);
}
