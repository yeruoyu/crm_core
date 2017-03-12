package com.lodge.crm.core.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lodge.crm.core.util.JqgridFilter;

public interface BaseJqGridService<T,ID extends Serializable> extends BaseService<T,ID>{

	public Page<T> findAll(JqgridFilter jqgridFilter, Pageable pageable);
}
