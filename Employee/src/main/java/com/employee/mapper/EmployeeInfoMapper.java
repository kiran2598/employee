package com.employee.mapper;

import org.springframework.stereotype.Component;

import com.employee.abstract_mapper.AbstractModelMapper;
import com.employee.domain.EmployeeInfoDomain;
import com.employee.model.EmployeeInfoModel;

@Component
public class EmployeeInfoMapper extends AbstractModelMapper<EmployeeInfoModel, EmployeeInfoDomain> {

	public Class<EmployeeInfoModel> entityType() {
		// TODO Auto-generated method stub
		return EmployeeInfoModel.class;
	}

	public Class<EmployeeInfoDomain> modelType() {
		// TODO Auto-generated method stub
		return EmployeeInfoDomain.class;
	}

}
