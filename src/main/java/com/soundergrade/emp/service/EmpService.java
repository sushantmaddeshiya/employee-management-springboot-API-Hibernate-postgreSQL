package com.soundergrade.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.soundergrade.emp.model.Employee;
import com.soundergrade.emp.repo.Emprepo;

@Service
public class EmpService {
	
	@Autowired
	Emprepo repo;
	public Employee saveEmp(Employee e) {
		repo.save(e);
		return e;
	}
	
	public List<Employee> getallEmployess() {
		return repo.findAll();
		
	}
	
	public Employee getEmpByID(int id) {
		 return repo.findById(id).get();
		
//		Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//        return ResponseEntity.ok().body(employee);
		
	}

	public Employee UpdateDetails(Employee employeeDetails, Integer employeeId) {
		
		 repo.deleteById(employeeId);
//		 Employee e=new Employee();
//		 e.setId(employeeId);
//		 e.setDepartment(employeeDetails.getDepartment());
//		 e.setEmail(employeeDetails.getEmail());
//		 e.setName(employeeDetails.getName());
//		 e.setPhone(employeeDetails.getPhone());
		 employeeDetails.setId(employeeId);
		 repo.save(employeeDetails);
		 return employeeDetails;
	}

	public void deleteEmp(Integer employeeId) {
		
		 repo.deleteById(employeeId);
	}
}
