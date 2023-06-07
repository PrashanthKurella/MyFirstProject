package com.jpa.hibernates.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity // to retrieve or change data here mapping course class with table which has
		// same fields id and name in database
public class Review {

	@Id // declaring id as primary key
	@GeneratedValue // unique value will generated automatically for id by JVM
	private Long id;
	private String description;
	private int rating;

	@ManyToOne
	private Course course;

	protected Review() {

	}

	public Review(String description, int rating) {
		this.description = description;
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return String.format("review= [%s]", description);
	}

}
