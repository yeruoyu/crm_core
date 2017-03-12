package com.lodge.crm.core.service;

import com.lodge.crm.core.entity.hibernate.TableKey;

public interface TableKeyService extends BaseService<TableKey,String>{

	public String getNewCode(String code);
}
