package com.jpa.hibernates.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernates.demo.entity.Course;
import com.jpa.hibernates.demo.entity.Passport;
import com.jpa.hibernates.demo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository // it shows bean not found if we wont mention repository annotation here
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;
	
	

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	// -> insert or update
	public Student save(Student Student) {
		if (Student.getId() == null) {
			em.persist(Student); // it will insert new value 
		} else {
			em.merge(Student); // it will update new value
		}
		return Student;
	}

	public void deleteById(Long id) {
		Student Student = findById(id);
		em.remove(Student);

	}
	
	public void platWithEntityManger() {
	/*	Student Student1 = new Student("Angulae Js in 100 steps");
		em.persist(Student1);// persist is used to insert 
		Student Student2 = new Student("Node Js in 100 steps");
		em.persist(Student2);
		
		em.flush();// used to persist all the changes untill now into database 
		
		// setname  updates below statement into database by using entity manage 
		//here entity manager tracks the record 
		 Student1.setName("Angulae Js in 100 steps - updated");
		 //em.detach(Student1);// em.clear (or) it will delete the updated Student1 value in database
		 
		 Student2.setName("Node Js in 100 steps - updated");
		 
		 em.refresh(Student1);// it will undo changes to previous Student1 value(Angular Js in 100 steps)add line number attributes to generated class file"
		 
		 em.flush();
		 
		 */
	}
	
	/*public void savePassportWithStudent() {
		Passport passport = new Passport("Z123546");
		em.persist(passport);
		
		Student student = new Student("katu");
		student.setPassport(passport);
		em.persist(student);
	}
	*/

	/*public void insertHardCodeStudentAndCourse() {
		Student student = new Student ("nani");
		Course course = new Course("microservises in 100 steps");
		em.persist(student);
		em.persist(course);
		
		
		student.addCourses(course);
		course.addStudent(student);
		em.persist(student);
		
	}*/
	
	public void retriveHardCodeStudentAndCourse(Student student, Course course) {
		//Student student = new Student ("nani");
		//Course course = new Course("microservises in 100 steps");
		
		student.addCourses(course);
		course.addStudent(student);
		em.persist(student);
		em.persist(course);
		
		
		
	}
	
	
}