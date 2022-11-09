package com.employee.management.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.employee.management.entity.Employee;
import com.employee.management.entity.Role;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.repository.RoleRepository;
import com.employee.management.repository.UserRepository;
import com.employee.management.service.MiscellaneousService;

@Service
public class MiscellaneousServiceImpl implements MiscellaneousService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Override
	public List<Employee> sortRecordByName(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}


	@Override
	public boolean checkExistingRole(String parameter) {
		Role role = new Role();
		role.setRoleName(parameter);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				                        .withMatcher(parameter, ExampleMatcher.GenericPropertyMatchers.exact())
				                        .withIgnorePaths("role_id","users");
		Example<Role> roleExample = Example.of(role, exampleMatcher);
		return roleRepository.exists(roleExample);
	
	}


}
