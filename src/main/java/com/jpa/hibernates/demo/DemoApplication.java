package com.jpa.hibernates.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernates.demo.entity.Course;
import com.jpa.hibernates.demo.entity.FullTimeEmployee;
import com.jpa.hibernates.demo.entity.PartTimeEmployee;
import com.jpa.hibernates.demo.entity.Student;
import com.jpa.hibernates.demo.repository.CourseRepository;
import com.jpa.hibernates.demo.repository.EmployeeRepository;
import com.jpa.hibernates.demo.repository.StudentRepository;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courserepository;

	@Autowired
	private StudentRepository studentrepository;
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//Course course = repository.findById(10001L);
		
		//logger.info("Course 10001 -> {}", course);
		
		
		//repository.deleteById(10001L); to delete one recored using deletebyId method
		
		/*repository.save(new Course("microservices in 100 steps"));
		repository.save(new Course("Java in 100 steps"));
		repository.save(new Course("springboot in 100 steps"));
		repository.save(new Course("core Java in 100 steps"));
		repository.save(new Course("SQL in 100 steps"));
		repository.save(new Course("course project in 100 steps"));
		*/
		
		
		//studentrepository.savePassportWithStudent();
		//courserepository.platWithEntityManger();
		
		//studentrepository.retriveHardCodeStudentAndCourse(new Student("kalyan"),new Course ("hibernets"));;
		
		employeerepository.insertEmlpoyee(new PartTimeEmployee("Atul", new BigDecimal("50")));
		employeerepository.insertEmlpoyee(new FullTimeEmployee("Jiteesh", new BigDecimal("10000")));
		
		logger.info("employeedetails -> {}", employeerepository.retriveAllEmployees());
		
	}
}