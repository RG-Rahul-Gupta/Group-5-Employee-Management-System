package com.employee.management.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.config.SecurityConfig;
import com.employee.management.entity.Employee;
import com.employee.management.entity.Role;
import com.employee.management.entity.User;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.repository.RoleRepository;
import com.employee.management.repository.UserRepository;
import com.employee.management.service.CreateService;
import com.employee.management.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired 
	CreateService createService;
	
	@Autowired
	SecurityConfig securityConfig;
	
	@Override
	public String updateRecordbyId(Employee newEmployee, User newUser, int id) {
	Employee oldEmployee = employeeRepository.findById(id).orElseThrow();
	User oldUser = userRepository.findById(id).orElseThrow();
	Role oldRole = oldUser.getRoles();
	if(newUser.getUserName()==null) {
		oldUser.setUserName(oldUser.getUserName());
	}
	else {
		oldUser.setUserName(newUser.getUserName());
	}
	if(newUser.getPassword()==null) {
		oldUser.setPassword(securityConfig.passwordEncoder().encode(oldUser.getPassword()));
	}
	else {
		oldUser.setPassword(securityConfig.passwordEncoder().encode(newUser.getPassword()));
	}
	if(newEmployee.getFirstName()==null) {
		oldEmployee.setFirstName(oldEmployee.getFirstName());
	}
	else {
		oldEmployee.setFirstName(newEmployee.getFirstName());
	}
	if(newEmployee.getLastName()==null) {
		oldEmployee.setLastName(oldEmployee.getLastName());
	}
	else {
		oldEmployee.setLastName(newEmployee.getLastName());
	}
	if(newEmployee.getEmailId()==null) {
		oldEmployee.setEmailId(oldEmployee.getEmailId());
	}
	else {
		oldEmployee.setEmailId(newEmployee.getEmailId());
	}
	if(newEmployee.getHierarchy()==0) {
		oldEmployee.setHierarchy(oldEmployee.getHierarchy());
		oldUser.setRoles(oldRole);
	}
	else {
		oldEmployee.setHierarchy(newEmployee.getHierarchy());
		int hierarchy = newEmployee.getHierarchy();
		Role newRole = roleRepository.findById(hierarchy).get();
		oldUser.setRoles(newRole);
	}
	    userRepository.saveAndFlush(oldUser);
		employeeRepository.saveAndFlush(oldEmployee);
	   	return "The Record with ID "+id+" Updated and Saved";
	}
	
	

}
