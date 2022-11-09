package com.employee.management.service;

import com.employee.management.entity.Employee;
import com.employee.management.entity.User;

public interface CreateService {

	public void createRoleIfNotFound(String parameter);
	public String insertSingleRecord(Employee employee, User user);
	public void createDefaultEmployeeAndUser();

}
