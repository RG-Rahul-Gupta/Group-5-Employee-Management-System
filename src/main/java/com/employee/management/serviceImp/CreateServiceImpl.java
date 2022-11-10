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
import com.employee.management.service.MiscellaneousService;
import com.employee.management.service.ReadService;

@Service
public class CreateServiceImpl implements CreateService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	MiscellaneousService miscService;
	
	@Autowired
	ReadService readService;
	
	@Autowired
	SecurityConfig securityConfig;
	
	@Override
	public String insertSingleRecord(Employee employee,User user) {
		int hierarchy = employee.getHierarchy();
		Role role = roleRepository.findById(hierarchy).get();
		user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
		user.setRoles(role);
		//employee.setUser(user);
		userRepository.saveAndFlush(user);
		employeeRepository.saveAndFlush(employee);
		return "Record Inserted to Employee Table"+hierarchy;
	
	}

	@Override
	public void createRoleIfNotFound(String parameter) {
		Role role = new Role();
			if(miscService.checkExistingRole(parameter)==false) {
				role.setRoleName(parameter);
				roleRepository.saveAndFlush(role);
			}	
		else {
			System.out.println("Role - ADMIN & USER Exist");
		}
		
	}
	
	@Override
	public void createDefaultEmployeeAndUser() {
		if(employeeRepository.existsById(1)) {
		System.out.println("Default Employee and User Exist");
		}
		else {
		Employee employee = new Employee();
		User user = new User();
	    Role role = roleRepository.findById(1).get();
		user.setUserName("Owner");
		user.setPassword(securityConfig.passwordEncoder().encode("qwerty"));
		user.setRoles(role);
		employee.setFirstName("Gill");
		employee.setLastName("Shawn");
		employee.setEmailId("GillShawntheOwner@gmail.com");
		employee.setHierarchy(1);
		System.out.println(user);
		System.out.println(employee);
		userRepository.saveAndFlush(user);
		employeeRepository.saveAndFlush(employee);
		}
	}

}
