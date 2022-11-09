package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.entity.Employee;
import com.employee.management.entity.User;
import com.employee.management.service.CreateService;

@RestController
@RequestMapping("/CreateServices")
public class CreateController {
	
	@Autowired
	CreateService createService;
	
	@PostMapping("/addRecord")
	public String addRecordEmployee(Employee employee,User user) {
		String message = createService.insertSingleRecord(employee,user);
		return message;
	}
	
	
}
