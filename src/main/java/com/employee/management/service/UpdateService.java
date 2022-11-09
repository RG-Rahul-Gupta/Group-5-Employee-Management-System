package com.employee.management.service;

import com.employee.management.entity.Employee;
import com.employee.management.entity.User;

public interface UpdateService {

	public String updateRecordbyId(Employee newEmployee, User newUser, int id);
	
}
