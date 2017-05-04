package com.lodge.crm.core.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lodge.crm.core.entity.hibernate.Student;
import com.lodge.crm.core.service.StudentService;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	@Override
	public Page<Student> findAll(JqgridFilter jqgridFilter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creatInBatch(Iterable<Student> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean delete(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Student> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean update(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInBatch(Iterable<Student> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findOne(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
