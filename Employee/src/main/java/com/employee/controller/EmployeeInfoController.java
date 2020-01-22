package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dao.EmployeeInfoDaoRepository;
import com.employee.response.ErrorObject;
import com.employee.response.Response;
import com.employee.service.EmployeeInfoService;
import com.employee.status.StatusCode;
import com.employee.utils.CommonUtils;
import com.employee.model.EmployeeInfoModel;

@RestController
public class EmployeeInfoController {
	
	@Autowired
	EmployeeInfoService employeeinfoservice;
	
	@Autowired
	EmployeeInfoDaoRepository employeeinfodaorepository;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public void addemployeeinfo(@RequestBody EmployeeInfoModel employeeinfo) throws Exception{
		
		employeeinfoservice.addemployeeinfo(employeeinfo);
	}

	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public String getallemployeeinfo() throws Exception{
		
		List<EmployeeInfoModel> employeeinfo =((EmployeeInfoService)employeeinfoservice).getallemployeeinfo();
		
		Response res = CommonUtils.getResponseObject("List of employeeinfo");
		if (employeeinfo.isEmpty()) {
			ErrorObject err = CommonUtils.getErrorResponse("employeeinfo Not Found", "employeeinfo Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		} else {
			res.setData(employeeinfo);
		}
		return CommonUtils.getJson(res);
		
	}
}
