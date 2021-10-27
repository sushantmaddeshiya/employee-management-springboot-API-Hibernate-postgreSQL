package com.soundergrade.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soundergrade.emp.model.Employee;



@Repository
public interface Emprepo extends JpaRepository<Employee,Integer>{


	
	

}
