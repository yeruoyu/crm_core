package com.lodge.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.common.Constants;
import com.lodge.crm.core.entity.hibernate.Publish;
import com.lodge.crm.core.repository.PublishRepository;
import com.lodge.crm.core.service.PublishService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="publishService")
@Transactional
public class PublishServiceImpl implements PublishService {

	@Autowired
	PublishRepository publishRepository;
	
	@Override
	public Boolean create(Publish entity) {
		Publish newPublish = publishRepository.saveAndFlush(entity);
		if(newPublish == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Publish> entities) {
		publishRepository.save(entities);
	}

	@Override
	public Boolean delete(Publish entity) {
		publishRepository.delete(entity);
		Publish exisitPublish = publishRepository.findOne(entity.getPublishId());
		if(exisitPublish !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Publish> entities) {
		publishRepository.deleteInBatch(entities);
	}

	@Override
	public Boolean update(Publish entity) {
		Publish exisitPublish = publishRepository.saveAndFlush(entity);
		if(exisitPublish == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Publish> entities) {
		publishRepository.save(entities);

	}

	@Override
	public List<Publish> findAll() {
		return publishRepository.findAll();
	}

	@Override
	public Page<Publish> findAll(Pageable pageable) {
		return publishRepository.findAll(pageable);
	}

	@Override
	public Publish findOne(Integer code) {
		Publish publish = publishRepository.findOne(code);
		return publish;
	}
	
	@Override
	public Page<Publish> findAllActive(Pageable pageable){
		return publishRepository.findAllActive(pageable);
	}
	
	@Override
	public Page<Publish> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Publish> spec = getWhereClause(jqgridFilter);
		return publishRepository.findAll(spec, pageable);
	}
	
	private Specification<Publish> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Publish>() {
        	@Override
			 public Predicate toPredicate(Root<Publish> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
						if(rule.getOp().equals("eq")){
							predicate.add(cb.equal(root.get(rule.getField()).as(String.class),rule.getData()));
						}
					}
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
        };
    }
}
