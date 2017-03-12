package com.lodge.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.common.Constants;
import com.lodge.crm.core.entity.hibernate.Customer;
import com.lodge.crm.core.entity.hibernate.CustomerRecord;
import com.lodge.crm.core.entity.hibernate.User;
import com.lodge.crm.core.repository.RecordRepository;
import com.lodge.crm.core.service.RecordService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="recordService")
@Transactional
public class RecordServiceImpl implements RecordService {

	@Autowired
	RecordRepository recordRepository;

	@Override
	public Boolean create(CustomerRecord entity) {
		CustomerRecord newRecord = recordRepository.saveAndFlush(entity);
		if(newRecord == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<CustomerRecord> entities) {
		recordRepository.save(entities);
	}

	@Override
	public Boolean delete(CustomerRecord entity) {
		recordRepository.delete(entity);
		CustomerRecord exisitRecord = recordRepository.findOne(entity.getRecordId());
		if(exisitRecord !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<CustomerRecord> entities) {
		recordRepository.deleteInBatch(entities);
	}

	@Override
	public Boolean update(CustomerRecord entity) {
		CustomerRecord exisitRecord = recordRepository.saveAndFlush(entity);
		if(exisitRecord == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<CustomerRecord> entities) {
		recordRepository.save(entities);
	}

	@Override
	public List<CustomerRecord> findAll() {
		return recordRepository.findAll();
	}

	@Override
	public Page<CustomerRecord> findAll(Pageable pageable) {
		return recordRepository.findAll(pageable);
	}

	@Override
	public CustomerRecord findOne(Long id) {
		return recordRepository.findOne(id);
	}
	
	@Override
	public Page<CustomerRecord> findAll(JqgridFilter jqgridFilter,
			Pageable pageable) {
		Specification<CustomerRecord> spec = getWhereClause(jqgridFilter);
		return recordRepository.findAll(spec, pageable);
	}
	
	private Specification<CustomerRecord> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<CustomerRecord>() {
        	@Override
			 public Predicate toPredicate(Root<CustomerRecord> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
						if(rule.getOp().equals("eq")){
							if(rule.getField().equals("userCode")){
								Join<CustomerRecord,User> uesrJoin = root.join(root.getModel().getSingularAttribute("recordUser", User.class), JoinType.INNER);
								predicate.add(cb.equal(uesrJoin.get("userCode").as(String.class), rule.getData()));
							}else if(rule.getField().equals("customerCode")){
								Join<CustomerRecord,Customer> customerJoin = root.join(root.getModel().getSingularAttribute("recordCustomer", Customer.class), JoinType.INNER);
								predicate.add(cb.equal(customerJoin.get("customerCode").as(String.class), rule.getData()));
							}else{
								predicate.add(cb.equal(root.get(rule.getField()).as(String.class), rule.getData()));
							}
						}
					}
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
        };
    }
	
	@Override
	public Page<CustomerRecord> findByCustomerCode(String customerCode,Pageable pageable){
		return recordRepository.findByCustomerCode(customerCode, pageable);
	}

}
