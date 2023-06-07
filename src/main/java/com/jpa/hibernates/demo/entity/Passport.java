package com.jpa.hibernates.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // to retrieve or change data here mapping course class with table which has
		// same fields id and name in database
public class Passport {

	@Id // declaring id as primary key
	@GeneratedValue // unique value will generated automatically for id by JVM
	private Long id;

	@Column(nullable = false)
	private String number;

	protected Passport() {

	}

	public Passport(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setnumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Passport[%s]", number);
	}

}
