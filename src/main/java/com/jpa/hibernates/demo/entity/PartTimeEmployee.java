package com.jpa.hibernates.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;


@Entity
public class PartTimeEmployee extends Employee  {
	
	private BigDecimal hourlywage;
	
	protected PartTimeEmployee() {};
	
	public PartTimeEmployee(String name, BigDecimal hourlywage ) {
		super(name);
		this.hourlywage= hourlywage;
	}
	

}
