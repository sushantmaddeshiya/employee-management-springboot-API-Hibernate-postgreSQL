package com.soundergrade.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soundergrade.emp.exception.ResourceNotFoundException;
import com.soundergrade.emp.model.Employee;
import com.soundergrade.emp.service.EmpService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmpController {
	  @Autowired
	    private EmpService service ;

	    @PostMapping("/employee")
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return service.saveEmp(employee);
	    }
	    
	    
	    @GetMapping("/allEmp")
	    public List<Employee> getAllEmp(){
	    	return service.getallEmployess();
	    }


//	    @GetMapping("/employees")
//	    public ResponseEntity<List<Employee>> getAllEmployees() {
//
//	        return ResponseEntity.ok(employeeRepository.findAll());
//	    }
//
	    @GetMapping("/employee/{id}")
	    public Employee getOneEmp(@PathVariable(value = "id") Integer employeeId) {
	    	return service.getEmpByID(employeeId);
	    	
	    }

	    @PutMapping("/employee/{id}")
	    public Employee updateEmployee(@PathVariable(value = "id") Integer employeeId, @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
	      return service.UpdateDetails(employeeDetails,employeeId);

	   
//	        return ResponseEntity.ok(updatedEmployee);
	    }
	    

	    @DeleteMapping("/employee/{id}")
	    public String delete(@PathVariable(value = "id") Integer employeeId){
	    	 service.deleteEmp( employeeId );
	    	 return "Deleted";
	    }
//	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
//	            throws ResourceNotFoundException {
//	        Employee employee = employeeRepository.findById(employeeId)
//	                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//	        employeeRepository.delete(employee);
//	        Map<String, Boolean> response = new HashMap<>();
//	        response.put("deleted", Boolean.TRUE);
//	        return response;
//	    }
	}
