package com.pace.employeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pace.emplyeeRepo.EmployeeRepo;
import com.pace.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	
	public Map registerEmployee(Employee employee) {
		Map<String, String> responseMap = new HashMap<String, String>();
		try {
			employeeRepo.save(employee);
			responseMap.put("status", "success");
			responseMap.put("description", "Employee details added");
		}catch (Exception e) {
			log.error("error occured" , e);
			responseMap.put("status", "error");
			responseMap.put("description", "Employee details failed to add");
		}
		return responseMap;
	}


	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepo.findById(id);
	}


	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}


	public Map deleteById(int id) {
		Map<String, String> responseMap = new HashMap<String, String>();
		try {
			employeeRepo.deleteById(id);
			responseMap.put("status", "success");
			responseMap.put("description", "Employee details deleted");
		}catch (Exception e) {
			log.error("error occured" , e);
			responseMap.put("status", "error");
			responseMap.put("description", "Employee details failed to delete");
		}
		return responseMap;
	}

	
}
