package com.lodge.crm.core.service;

import java.util.List;

import com.lodge.crm.core.entity.hibernate.DistInfo;

public interface DistInfoService extends BaseJqGridService<DistInfo,Integer> {

	List<DistInfo> findDistInfoByType(String type);
}
