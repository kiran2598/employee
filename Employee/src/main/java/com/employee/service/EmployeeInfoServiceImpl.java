package com.employee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.response.Response;
import com.employee.dao.EmployeeInfoDao;
import com.employee.dao.EmployeeInfoDaoRepository;
import com.employee.domain.EmployeeInfoDomain;
import com.employee.mapper.EmployeeInfoMapper;
import com.employee.model.EmployeeInfoModel;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeInfoServiceImpl.class);
	
	@Autowired
	EmployeeInfoDao employeeinfodao;
	
	@Autowired
	EmployeeInfoMapper employeeinfomapper;
	
	@Autowired
	EmployeeInfoDaoRepository employeeinfodaorepository;

	@Override
	public Response addemployeeinfo(EmployeeInfoModel employeeinfo) throws Exception {
		try {
			EmployeeInfoDomain employeeinfodomain=new EmployeeInfoDomain();
			BeanUtils.copyProperties(employeeinfo,employeeinfodomain );
			return 	employeeinfodao.addemployeeinfo(employeeinfodomain);

			}
			catch(Exception e) {
				System.out.println("Exception in add employee info");
				logger.error("Exception in add employee info");
			
			}
		return null;
	}

	@Override
	public EmployeeInfoModel getemployeeinfo(int Id) throws Exception {
		try {
			EmployeeInfoDomain employeeinfodomain=employeeinfodao.getbyid(Id);
			EmployeeInfoModel employeeinfo = new EmployeeInfoModel();
			
			BeanUtils.copyProperties(employeeinfodomain, employeeinfo);
			return employeeinfo;
			}catch(Exception e) {
			System.out.println(e);
			//logger.info("Exception getEmployee:", e.getMessage());
			System.out.println(e);
			}
		return null;
	}

	@Override
	public List<EmployeeInfoModel> getallemployeeinfo() throws Exception {
		try {
			List<EmployeeInfoDomain> allemployeeinfo = employeeinfodao.getallids();
			List<EmployeeInfoModel> model=employeeinfomapper.entityList(allemployeeinfo);
			return model;
			}
			catch(Exception d) {
				System.out.println(d);
			}
		return null;
	}

}
