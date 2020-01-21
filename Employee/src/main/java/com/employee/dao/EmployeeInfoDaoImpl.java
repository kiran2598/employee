package com.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.response.Response;
import com.employee.status.StatusCode;
import com.employee.utils.CommonUtils;
import com.employee.domain.EmployeeInfoDomain;

@Repository
@Transactional
public class EmployeeInfoDaoImpl implements EmployeeInfoDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	EmployeeInfoDaoRepository employeeinfodaorepsoitory;
	

	@Override
	public Response addemployeeinfo(EmployeeInfoDomain employeeinfodomain) throws Exception {
		Response response = CommonUtils.getResponseObject("Add employee info");
		try {
			entityManager.persist(employeeinfodomain);
			response.setStatus(StatusCode.SUCCESS.name());
		} catch (Exception e) {
			
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
		}
		return response;
	}

	@Override
	public EmployeeInfoDomain getbyid(int Id) throws Exception {
		String hql="From employeeinfo where Id=:ab";
		return (EmployeeInfoDomain) entityManager.createQuery(hql).setParameter("ab", Id).getSingleResult();
	}

	@Override
	public List<EmployeeInfoDomain> getallids() throws Exception {
		try {
			List<EmployeeInfoDomain> listEmployeeInfoDomain=employeeinfodaorepsoitory.findAll();
			return listEmployeeInfoDomain;
		
		}catch(Exception e1) {
			System.out.println(e1);
		}
		return null;
	}

}
