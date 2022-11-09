package com.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
