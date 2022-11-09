package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.service.DeleteService;

@RestController
@RequestMapping("/DeleteServices")
public class DeleteController {

	@Autowired
	DeleteService deleteService;
	
	@DeleteMapping("/{id}")
	public String deleteRecord(@PathVariable("id") int id) {
		String message =deleteService.deleteSingleRecordById(id);
		return message;
	}
}
