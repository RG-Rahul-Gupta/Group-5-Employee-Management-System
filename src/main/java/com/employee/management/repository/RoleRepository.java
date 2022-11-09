package com.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
