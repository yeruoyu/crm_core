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
import com.lodge.crm.core.entity.hibernate.DistInfo;
import com.lodge.crm.core.repository.DistInfoRepository;
import com.lodge.crm.core.service.DistInfoService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="distInfoService")
@Transactional
public class DistInfoServiceImpl implements DistInfoService {

	@Autowired
	DistInfoRepository distInfoRepository;
	
	@Override
	public Boolean create(DistInfo entity) {
		DistInfo newDistInfo = distInfoRepository.saveAndFlush(entity);
		if(newDistInfo ==null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<DistInfo> entities) {
		distInfoRepository.save(entities);

	}

	@Override
	public Boolean delete(DistInfo entity) {
		distInfoRepository.delete(entity);
		DistInfo exisitDistInfo = distInfoRepository.findOne(entity.getDistId());
		if(exisitDistInfo !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<DistInfo> entities) {
		distInfoRepository.deleteInBatch(entities);

	}

	@Override
	public Boolean update(DistInfo entity) {
		DistInfo exisitDistInfo = distInfoRepository.saveAndFlush(entity);
		if(exisitDistInfo == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<DistInfo> entities) {
		distInfoRepository.save(entities);
	}

	@Override
	public List<DistInfo> findAll() {
		return distInfoRepository.findAll();
	}

	@Override
	public Page<DistInfo> findAll(Pageable pageable) {
		return distInfoRepository.findAll(pageable);
	}

	@Override
	public DistInfo findOne(Integer code) {
		DistInfo distInfo = distInfoRepository.findOne(code);
		return distInfo;
	}
	
	@Override
	public Page<DistInfo> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<DistInfo> spec = getWhereClause(jqgridFilter);
		return distInfoRepository.findAll(spec, pageable);
	}
	
	private Specification<DistInfo> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<DistInfo>() {
        	@Override
			 public Predicate toPredicate(Root<DistInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
					}
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
        };
    }

	public List<DistInfo> findDistInfoByType(String distType){
		return distInfoRepository.findDistInfoByType(distType);
	}
	
}
