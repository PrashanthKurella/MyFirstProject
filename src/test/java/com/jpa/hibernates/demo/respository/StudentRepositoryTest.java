package com.jpa.hibernates.demo.respository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernates.demo.entity.Course;
import com.jpa.hibernates.demo.entity.Student;
import com.jpa.hibernates.demo.repository.CourseRepository;
import com.jpa.hibernates.demo.repository.StudentRepository;

import jakarta.persistence.EntityManager;

@SpringBootTest
class StudentRepositoryTest {
	
			private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentrepository;
	
	@Autowired
	EntityManager em;

	@Test
	@Transactional // if we wont mention it will show 'no session' error because we mentioned fetch type is lazy 
	public void retriveStudentAndPassport() {

		Student student = em.find(Student.class, 20001L);
		logger.info("studnet -->{} ",student);
		logger.info("passport -->{} ",student.getPassport());
		}

	@Test
	@Transactional 
	public void retriveStudentAndCourse() {

		Student student = em.find(Student.class, 20001L);
		logger.info("student -->{} ",student);
		logger.info("passport -->{} ",student.getPassport());
		
	}
		
	
	

}
