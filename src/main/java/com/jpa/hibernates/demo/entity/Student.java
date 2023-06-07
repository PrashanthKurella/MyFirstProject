package com.jpa.hibernates.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity // to retrieve or change data here mapping course class with table which has
		// same fields id and name in database
public class Student {

	@Id // declaring id as primary key
	@GeneratedValue // unique value will generated automatically for id by JVM
	private Long id;

	@Column(nullable = false)
	private String name;
	
	/* primary key of passport ID is foreign key here in this student table as PASSPORT_ID.. here 
	we declared passport as foreign key with type of Passport(class which we already created)
	linking two table with one to one annotation
	*/
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;

	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE",
	joinColumns  = @JoinColumn(name ="STUDENT_ID"),
			inverseJoinColumns  = @JoinColumn(name ="COURSE_ID"))
	private List<Course> courses = new ArrayList<>();
	
	/* query to search joint relation
	 * SELECT * FROM STUDENT_COURSE, STUDENT, COURSE
WHERE STUDENT_COURSE.STUDENT_ID = STUDENT.ID AND
STUDENT_COURSE.COURSE_ID = COURSE.ID
*/
	
	protected Student() {

	}

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course course) {
		this.courses.add(course);
	}

	@Override
	public String toString() {
		return String.format("student[%s]", name);
	}

}
