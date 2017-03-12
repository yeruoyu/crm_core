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
import com.lodge.crm.core.entity.hibernate.Channel;
import com.lodge.crm.core.repository.ChannelRepository;
import com.lodge.crm.core.service.ChannelService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="channelService")
@Transactional
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	ChannelRepository channelRepository;
	
	@Override
	public Boolean create(Channel entity) {
		Channel newChannel = channelRepository.saveAndFlush(entity);
		if(newChannel == null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Channel> entities) {
		channelRepository.save(entities);
	}

	@Override
	public Boolean delete(Channel entity) {
		channelRepository.delete(entity);
		Channel exisitChannel = channelRepository.findOne(entity.getChannelCode());
		if(exisitChannel !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Channel> entities) {
		channelRepository.delete(entities);
	}

	@Override
	public Boolean update(Channel entity) {
		Channel exisitChannel = channelRepository.saveAndFlush(entity);
		if(exisitChannel == null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Channel> entities) {
		channelRepository.save(entities);
	}

	@Override
	public List<Channel> findAll() {
		return channelRepository.findAll();
	}

	@Override
	public Page<Channel> findAll(Pageable pageable) {
		return channelRepository.findAll(pageable);
	}

	@Override
	public Channel findOne(String code) {
		return channelRepository.findOne(code);
	}

	@Override
	public Page<Channel> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		Specification<Channel> spec = getWhereClause(jqgridFilter);
		return channelRepository.findAll(spec, pageable);
	}
	
	private Specification<Channel> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Channel>() {
        	@Override
			 public Predicate toPredicate(Root<Channel> root, CriteriaQuery<?> query, CriteriaBuilder cb){
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
