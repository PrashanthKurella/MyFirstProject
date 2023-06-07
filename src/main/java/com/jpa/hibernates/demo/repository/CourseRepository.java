package com.jpa.hibernates.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernates.demo.entity.Course;

import jakarta.persistence.EntityManager;

@Repository // it shows bean not found if we wont mention repository annotation here
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	// -> insert or update
	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course); // it will insert new value 
		} else {
			em.merge(course); // it will update new value
		}
		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);

	}
	
	public void platWithEntityManger() {
		Course course1 = new Course("Angulae Js in 100 steps");
		em.persist(course1);// persist is used to insert 
		Course course2 = new Course("Node Js in 100 steps");
		em.persist(course2);
		
		em.flush();// used to persist all the changes untill now into database 
		
		/*// setname  updates below statement into database by using entity manage 
		//here entity manager tracks the record 
		 course1.setName("Angulae Js in 100 steps - updated");
		 //em.detach(course1);// em.clear (or) it will delete the updated course1 value in database
		 
		 course2.setName("Node Js in 100 steps - updated");
		 
		 em.refresh(course1);// it will undo changes to previous course1 value(Angular Js in 100 steps)add line number attributes to generated class file"
		 
		 em.flush();
		 
		 */
	}

}