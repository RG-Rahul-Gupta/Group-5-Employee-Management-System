package com.employee.management.service;

public interface DeleteService {
	
	public void deleteMultipleRecordByIds();
	public void deleteAllRecords();
	public String deleteSingleRecordById(int id);

}
