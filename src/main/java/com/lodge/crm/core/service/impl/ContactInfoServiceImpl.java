package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.ContactInfo;
import com.lodge.crm.core.repository.ContactInfoRepository;
import com.lodge.crm.core.service.ContactInfoService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="contactInfoService")
@Transactional
public class ContactInfoServiceImpl implements ContactInfoService {

	@Autowired
	ContactInfoRepository contactInfoRepository;
	
	@Override
	public Page<ContactInfo> findAll(JqgridFilter jqgridFilter,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(ContactInfo entity) {
		contactInfoRepository.saveAndFlush(entity);
		return true;
	}

	@Override
	public void creatInBatch(Iterable<ContactInfo> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(ContactInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<ContactInfo> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(ContactInfo entity) {
		contactInfoRepository.saveAndFlush(entity);
		return true;
	}

	@Override
	public void updateInBatch(Iterable<ContactInfo> entities) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<ContactInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContactInfo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactInfo findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ContactInfo> findContactByCustCode(String customerCode,Pageable pageable){
		return contactInfoRepository.findContactByCustCode(customerCode,pageable);
	}
	
	@Override
	public ContactInfo findContactByContactMobile(String mobile){
		return contactInfoRepository.findContactByContactMobile(mobile);
	}
	
	@Override
	public Boolean checkContactByMobile(String mobile,Long contactId){
		ContactInfo contact = contactInfoRepository.findContactByContactMobile(mobile);
		if(contact !=null ){
			if(contactId==null){
				return false;
			}
			if(contact.getContactId().equals(contactId)){
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}
}
