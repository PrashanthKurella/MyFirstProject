package com.jpa.hibernates.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity // to retrieve or change data here mapping course class with table which has same fields id and name in database
public class Course {
	
	
	@Id   //declaring id as primary key
	@GeneratedValue   // unique value will generated automatically for id by JVM 
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@OneToMany()
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy ="courses")
	private List<Student> student = new ArrayList<>();
	
protected Course() {
		
	}
	
	public Course(String name) {
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
	
	

	public LocalDateTime getlastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setlastUpdatedDate(LocalDateTime lastUpdatedDate) {
		lastUpdatedDate = lastUpdatedDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReviews(Review review) {
		this.reviews.remove(review);
	}
	
	

	public List<Student> getStudent() {
		return student;
	}

	public void addStudent(Student student) {
		this.student.add(student);
	}

	@Override
	public String toString() {
		return String.format("Course[%s]",name) ;
	}

	
	

	
	
}
