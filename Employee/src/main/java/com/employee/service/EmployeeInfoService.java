package com.employee.service;

import java.util.List;

import com.employee.response.Response;
import com.employee.model.EmployeeInfoModel;

public interface EmployeeInfoService {
	
	public Response addemployeeinfo(EmployeeInfoModel employeeinfo) throws Exception;
	
	public EmployeeInfoModel getemployeeinfo(int Id) throws Exception;
	
	public List<EmployeeInfoModel> getallemployeeinfo() throws Exception;

}
