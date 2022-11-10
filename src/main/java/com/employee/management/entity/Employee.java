package com.employee.management.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="employee")
public class Employee  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	
	private String firstName;
	private String lastName;
	private String emailId;
	private int hierarchy;
	
//	@JsonManagedReference
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name="user_id",nullable = false,referencedColumnName = "user_id" )
//	private User user;
	
}
