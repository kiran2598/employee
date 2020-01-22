package com.employee.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.dao.EmployeeInfoDaoRepository;
import com.employee.model.EmployeeInfoModel;
import com.employee.response.ErrorObject;
import com.employee.response.Response;
import com.employee.service.EmployeeInfoService;
import com.employee.status.StatusCode;
import com.employee.utils.CommonUtils;

public class EmployeeInfoControllerRetriveById {
	
	@Autowired
	EmployeeInfoService employeeinfoservice;
	
	@Autowired
	EmployeeInfoDaoRepository employeeinfodaorepository;
	
	

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody String getemployeeinfo(@PathVariable ("id") int id) throws Exception{
		
		EmployeeInfoModel model = employeeinfoservice.getemployeeinfo(id);
		
		Response res = CommonUtils.getResponseObject(" employee info found");
		if (model==null) {
			ErrorObject err = CommonUtils.getErrorResponse("employee info Not Found", "employee info Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(model);
		}
		return CommonUtils.getJson(res);
	}
	
		
	

}
