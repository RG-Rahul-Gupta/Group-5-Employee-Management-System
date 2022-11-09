package com.employee.management.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.employee.management.entity.Employee;

public interface MiscellaneousService {
	
	public List<Employee> sortRecordByName(Direction direction);
	public boolean checkExistingRole(String parameter);

}
