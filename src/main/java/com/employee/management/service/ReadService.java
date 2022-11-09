package com.employee.management.service;

import java.util.List;
import java.util.Optional;

import com.employee.management.entity.Employee;
import com.employee.management.entity.User;


public interface ReadService {
	
	public List<Employee> fetchAllRecords();
	public Employee fetchRecordbyId(int id);
	public List<Employee> fetchAllRecordsbyIds(List<Integer> id);
	List<Employee> fetchAllRecordbyFirstName(String firstName);
	public Optional<User> fetchUserbyUserName(String userName);
	

}
