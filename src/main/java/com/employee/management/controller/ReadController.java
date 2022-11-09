package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

import com.employee.management.entity.Employee;
import com.employee.management.service.MiscellaneousService;
import com.employee.management.service.ReadService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ReadServices")
public class ReadController {
	
	@Autowired
	ReadService readService;
	
	@Autowired
	MiscellaneousService miscService;
	
	@GetMapping
	public List<Employee> getAllRecords() {
		return readService.fetchAllRecords();
	}
	
	@GetMapping("/{id}")
	public Employee getRecordById(@PathVariable("id") int id){
		return readService.fetchRecordbyId(id);
	}
	
	@GetMapping("/sort")
	public List<Employee> getAllRecordsSortedbyFirstName(Direction order) {
		return miscService.sortRecordByName(order);
	}
	
	@GetMapping("/search")
	public List<Employee> getAllRecordsbyFirstName( String firstName){
		return readService.fetchAllRecordbyFirstName(firstName);
	}

}
