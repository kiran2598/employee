package com.employee.dao;

import java.util.List;

import com.employee.domain.EmployeeInfoDomain;
import com.employee.response.Response;

public interface EmployeeInfoDao {

	public Response addemployeeinfo(EmployeeInfoDomain employeeinfodomain) throws Exception;
	
	public EmployeeInfoDomain getbyid(int Id ) throws Exception;
	
	public List<EmployeeInfoDomain> getallids() throws Exception;
}
