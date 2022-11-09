package com.employee.management.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.employee.management.entity.Employee;
import com.employee.management.entity.User;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.repository.RoleRepository;
import com.employee.management.repository.UserRepository;
import com.employee.management.service.ReadService;

@Service
public class ReadServiceImpl implements ReadService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ReadService readService;
	
	@Override
	public List<Employee> fetchAllRecords() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee fetchRecordbyId(int id) {
		return employeeRepository.findById(id).orElseThrow();
	}

	@Override
	public List<Employee> fetchAllRecordsbyIds(List<Integer> ids) {
		return employeeRepository.findAllById(ids);
	}
	
	@Override
	public List<Employee> fetchAllRecordbyFirstName(String firstName){
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("emp_id","lastName","emailId");
		Example<Employee> firstNameExample = Example.of(employee, exampleMatcher);
		return employeeRepository.findAll(firstNameExample);
		
	}
	
	@Override
	public Optional<User> fetchUserbyUserName(String userName) {
		User user = new User();
		user.setUserName(userName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withMatcher(userName, ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("user_id","password","role_id");
		Example<User> userNameExample = Example.of(user,exampleMatcher);
		return userRepository.findOne(userNameExample);
		
	}
}
