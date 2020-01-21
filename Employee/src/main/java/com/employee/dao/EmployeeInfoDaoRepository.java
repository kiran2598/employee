package com.employee.dao;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.domain.EmployeeInfoDomain;

public interface EmployeeInfoDaoRepository extends JpaRepository<EmployeeInfoDomain, Id> {

}
