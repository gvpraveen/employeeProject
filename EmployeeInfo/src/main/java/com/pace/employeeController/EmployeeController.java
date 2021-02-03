package com.pace.employeeController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pace.employeeService.EmployeeService;
import com.pace.model.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	
	@Autowired
	EmployeeService employeeService;
	

	// Task 1
	@CrossOrigin
	@PostMapping("/registerEmployee")
	public Map registerEmployee(Employee employee) {
		return employeeService.registerEmployee(employee);
	}
	
	
	// Task 2
	//for save and update we can use same jpa method as we pass id it will update, otherwise it will insert new record
	@CrossOrigin
	@PostMapping("/updateEmployee")
	public Map updateEmployee(Employee employee) {
		return employeeService.registerEmployee(employee);
	}
	
	
	// Task 3
	@CrossOrigin
	@GetMapping("/getEmployee")
	public List<Employee> getEmployee() {
			return employeeService.getAllEmployees();
	}
	
	@CrossOrigin
	@GetMapping("/getEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
			return employeeService.getEmployeeById(id);
	}
	
	
	
	// Task 4
	@CrossOrigin
	@GetMapping("/deleteEmployee/{id}")
	public Map deleteEmployee(@PathVariable int id) {
			return employeeService.deleteById(id);
	}
		
	
	
	
}
