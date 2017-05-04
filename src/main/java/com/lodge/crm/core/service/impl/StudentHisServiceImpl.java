package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.StudentHis;
import com.lodge.crm.core.service.StudentHisService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="studentHisService")
@Transactional
public class StudentHisServiceImpl implements StudentHisService {

	@Override
	public Page<StudentHis> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(StudentHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatInBatch(Iterable<StudentHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(StudentHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<StudentHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(StudentHis entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<StudentHis> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentHis> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<StudentHis> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentHis findOne(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

}
