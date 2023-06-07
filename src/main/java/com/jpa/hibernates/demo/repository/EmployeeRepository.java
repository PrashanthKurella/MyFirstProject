package com.jpa.hibernates.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernates.demo.entity.Course;
import com.jpa.hibernates.demo.entity.Employee;
import java.util.List;
import jakarta.persistence.EntityManager;

@Repository // it shows bean not found if we wont mention repository annotation here
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager em;

	// -> insert
	public void insertEmlpoyee(Employee emp) {
		em.persist(emp);
	}

	// -> retriveAll
	public List<Employee> retriveAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}

}