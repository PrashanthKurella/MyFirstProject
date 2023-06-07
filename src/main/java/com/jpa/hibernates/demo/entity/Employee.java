package com.jpa.hibernates.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

//@MappedSuperclass // there is no relation between table its like separate tables
@Entity // to retrieve or change data here mapping course class with table which has
		// same fields id and name in database
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // all subclass entities(parttimeemploee andfulltimeemployee) will
														// store in single table
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//It creates separate table per entity
//@Inheritance(strategy = InheritanceType.JOINED)// it create separate table per entity while fetching we can use joins 
@DiscriminatorColumn(name = "EmployeeType") // declaring distinguished(DType) column name as employeetype by using
											// discriminatorcolumn annotation
public abstract class Employee {

	@Id // declaring id as primary key
	@GeneratedValue // unique value will generated automatically for id by JVM
	private Long id;

	@Column(nullable = false)
	private String name;

	protected Employee() {

	}

	public Employee(String name) {
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

	@Override
	public String toString() {
		return String.format("emloyee[%s]", name);
	}

}
