package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.entity.Employee;
import com.employee.management.entity.User;
import com.employee.management.service.UpdateService;

@RestController
@RequestMapping("/UpdateServices")
public class UpdateController {

	@Autowired
	UpdateService updateService;
	
	@PutMapping("/{id}")
	public String updateRecord(Employee employee, User user,@PathVariable("id") int id) {
		String message = updateService.updateRecordbyId(employee,user,id);
		return message;
		
	}
}
