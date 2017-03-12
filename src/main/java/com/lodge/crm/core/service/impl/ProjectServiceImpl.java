package com.lodge.crm.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.lodge.crm.core.entity.hibernate.Project;
import com.lodge.crm.core.entity.hibernate.School;
import com.lodge.crm.core.repository.ProjectRepository;
import com.lodge.crm.core.service.ProjectService;
import com.lodge.crm.core.util.DateUtils;
import com.lodge.crm.core.util.JqgridFilter;

@Service(value="projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Boolean create(Project entity) {
		Project newProject = projectRepository.saveAndFlush(entity);
		if(newProject ==null){
			return false;
		}
		return true;
	}

	@Override
	public void creatInBatch(Iterable<Project> entities) {
		projectRepository.save(entities);
	}

	@Override
	public Boolean delete(Project entity) {
		projectRepository.delete(entity);
		Project exisitProject = projectRepository.findOne(entity.getProjectCode());
		if(exisitProject !=null){
			return false;
		}
		return true;
	}

	@Override
	public void deleteInBatch(Iterable<Project> entities) {
		projectRepository.deleteInBatch(entities);
		
	}

	@Override
	public Boolean update(Project entity) {
		Project exisitProject = projectRepository.saveAndFlush(entity);
		if(exisitProject ==null){
			return false;
		}
		return true;
	}

	@Override
	public void updateInBatch(Iterable<Project> entities) {
		projectRepository.save(entities);
		
	}

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Page<Project> findAll(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}
	
	@Override
	public List<Project> findEnableProject(){
		Date currentDate = DateUtils.getCurrentDateTime();
		
		return projectRepository.findEnableProject(currentDate);
	}

	@Override
	public Project findOne(String code) {
		return projectRepository.getOne(code);
	}

	@Override
	public Page<Project> findByProjectName(String projectName,
			Pageable pageRequest) {
		return projectRepository.findByProjectNameLike("%"+projectName+"%",pageRequest);
	}

	@Override
	public Page<Project> findBySchool(School school, Pageable pageable) {
		Page<Project> projects = projectRepository.findBySchool(school,pageable);
		return projects;
	}
	
	public Page<Project> findAll(JqgridFilter jqgridFilter, Pageable pageable){
		Specification<Project> spec = getWhereClause(jqgridFilter);
		return this.projectRepository.findAll(spec,pageable);
	}
	
	private Specification<Project> getWhereClause(final JqgridFilter jqgridFilter){
        return new Specification<Project>() {
        	@Override
			 public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				List<Predicate> predicate = new ArrayList<>();
				for (JqgridFilter.Rule rule: jqgridFilter.getRules()) {
					if(rule.getData() !=null && !Constants._BLANK.equals(rule.getData())){
						if(rule.getOp().equals("cn")){
							predicate.add(cb.like(root.get(rule.getField()).as(String.class), "%" + rule.getData() + "%"));
						}
						if(rule.getOp().equals("eq")){
							if(rule.getField().equals("schoolCode")){
								Join<Project,School> schoolJoin = root.join(root.getModel().getSingularAttribute("school", School.class), JoinType.INNER);
								predicate.add(cb.equal(schoolJoin.get("schoolCode").as(String.class), rule.getData()));
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
}
