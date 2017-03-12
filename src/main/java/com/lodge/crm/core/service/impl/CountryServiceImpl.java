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
import com.lodge.crm.core.entity.hibernate.Country;
import com.lodge.crm.core.repository.CountryRepository;
import com.lodge.crm.core.service.CountryService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="countryService")
@Transactional
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Boolean create(Country entity) {
		Country newCountry = countryRepository.saveAndFlush(entity);
		if(newCountry == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Country> entities) {
		countryRepository.save(entities);
	}

	@Override
	public Boolean delete(Country entity) {
		countryRepository.delete(entity);
		Country exisitCountry = countryRepository.findOne(entity.getCountryCode());
		if(exisitCountry !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Country> entities) {
		countryRepository.deleteInBatch(entities);
		
	}

	@Override
	public Boolean update(Country entity) {
		Country exisitCountry = countryRepository.saveAndFlush(entity);
		if(exisitCountry == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Country> entities) {
		countryRepository.save(entities);
	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public Page<Country> findAll(Pageable pageable) {
		return countryRepository.findAll(pageable);
	}

	@Override
	public Country findOne(String code) {
		return countryRepository.findOne(code);
	}
	
	@Override
	public Page<Country> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Country> spec = getWhereClause(jqgridFilter);
		return countryRepository.findAll(spec, pageable);
	}
	
	private Specification<Country> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Country>() {
        	@Override
			 public Predicate toPredicate(Root<Country> root, CriteriaQuery<?> query, CriteriaBuilder cb){
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
}
