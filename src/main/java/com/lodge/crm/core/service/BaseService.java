package com.lodge.crm.core.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * base service
 * @author Administrator
 *
 * @param <T>
 */
public interface BaseService<T,ID extends Serializable> {

	/**
	 * create one entity
	 * @param entity
	 */
	public Boolean create(T entity);
	
	/**
	 * create several entities
	 * @param entities
	 */
	public void creatInBatch(Iterable<T> entities);
	
	/**
	 * delete entity 
	 * @param entity
	 */
	public Boolean delete(T entity);
	
	/**
	 * delete several entities
	 * @param entities
	 */
	public void deleteInBatch(Iterable<T> entities);
	
	/**
	 * update entity
	 * @param entity
	 */
	public Boolean update(T entity);
	
	/**
	 * update several entities
	 * @param entities
	 */
	public void updateInBatch(Iterable<T> entities);
	
	/**
	 * find all
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * find all by pageable
	 * @param pageable
	 * @return
	 */
	public Page<T> findAll(Pageable pageable);
	
	public T findOne(ID code);

}
