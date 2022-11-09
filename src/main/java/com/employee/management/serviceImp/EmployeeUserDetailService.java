package com.employee.management.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.management.entity.EmployeeUserDetails;
import com.employee.management.entity.User;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.repository.UserRepository;
import com.employee.management.service.ReadService;

@Service
public class EmployeeUserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ReadService readService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = readService.fetchUserbyUserName(username).orElseThrow(()->new UsernameNotFoundException("Following User Name does Not Exist in our Database"));
		System.out.println("User Found");
		return new EmployeeUserDetails(user) ;
	}
}
