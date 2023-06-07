package com.jpa.hibernates.demo.respository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.jpa.hibernates.demo.entity.Course;
import com.jpa.hibernates.demo.repository.CourseRepository;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	CourseRepository repository;

	@Test
	public void findById_basic() {

		Course course = repository.findById(10001L);
		assertEquals("bobby", course.getName());

	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {

		repository.deleteById(10001L);
		Course course = repository.findById(10001L);
		assertNull(course);

	}
	
	
	@Test
	@DirtiesContext
	public void save_basic() {

		//get the course
		Course course = repository.findById(10001L);
		assertEquals("bobby", course.getName());
		
		//update the course
		course.setName("bobby is replaced with nagaraju");
		repository.save(course);
		
		//check the value
		Course course1 = repository.findById(10001L);
		
		assertEquals("bobby is replaced with nagaraju", course1.getName());

	}
	

}
