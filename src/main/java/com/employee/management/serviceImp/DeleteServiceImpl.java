package com.employee.management.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.repository.EmployeeRepository;
import com.employee.management.repository.UserRepository;
import com.employee.management.service.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public String deleteSingleRecordById(int id) {
		userRepository.deleteById(id);
		employeeRepository.deleteById(id);
		return "The record with ID "+id+" deleted form Database with its associated properties";
			
	}

	@Override
	public void deleteMultipleRecordByIds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllRecords() {
		// TODO Auto-generated method stub
		
	}

}
