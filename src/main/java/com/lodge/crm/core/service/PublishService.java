package com.lodge.crm.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.entity.hibernate.Publish;

public interface PublishService extends BaseJqGridService<Publish,Integer>{

	Page<Publish> findAllActive(Pageable pageable);
}
