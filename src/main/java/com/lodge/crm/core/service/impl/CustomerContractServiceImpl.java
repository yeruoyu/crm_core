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
import com.lodge.crm.core.entity.hibernate.CustomerContract;
import com.lodge.crm.core.repository.CustomerContractRepository;
import com.lodge.crm.core.service.CustomerContractService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="customerContractService")
@Transactional
public class CustomerContractServiceImpl implements CustomerContractService {

	@Autowired
	CustomerContractRepository customerContractRepository;

	@Override
	public Boolean create(CustomerContract entity) {
		CustomerContract newContract = this.customerContractRepository.save(entity);
		if(newContract ==null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<CustomerContract> entities) {
		this.customerContractRepository.save(entities);
	}

	@Override
	public Boolean delete(CustomerContract entity) {
		this.customerContractRepository.delete(entity);
		CustomerContract exisitContract = this.customerContractRepository.findOne(entity.getCcId());
		if(exisitContract!=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<CustomerContract> entities) {
		this.customerContractRepository.delete(entities);
	}

	@Override
	public Boolean update(CustomerContract entity) {
		this.customerContractRepository.saveAndFlush(entity);
		return true;
	}

	@Override
	public void updateInBatch(Iterable<CustomerContract> entities) {
		this.customerContractRepository.save(entities);
	}

	@Override
	public List<CustomerContract> findAll() {
		return this.customerContractRepository.findAll();
	}

	@Override
	public Page<CustomerContract> findAll(Pageable pageable) {
		return this.customerContractRepository.findAll(pageable);
	}

	@Override
	public CustomerContract findOne(Long id) {
		return this.customerContractRepository.findOne(id);
	}

	@Override
	public Page<CustomerContract> findAll(JqgridFilter jqgridFilter,
			Pageable pageable) {
		Specification<CustomerContract> spec = getWhereClause(jqgridFilter);
		return customerContractRepository.findAll(spec, pageable);
	}

	private Specification<CustomerContract> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<CustomerContract>() {
        	@Override
			 public Predicate toPredicate(Root<CustomerContract> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
						if(rule.getOp().equals("eq")){
							predicate.add(cb.equal(root.get(rule.getField()).as(String.class), rule.getData()));
						}
					}
				}
				Predicate[] pre = new Predicate[predicate.size()];
				return query.where(predicate.toArray(pre)).getRestriction();
			}
        };
    }
	
	@Override
	public Page<CustomerContract> findByCustomerCode(String customerCode,
			Pageable pageable) {
		return this.customerContractRepository.findByCustomerCode(customerCode,pageable);
	}
}