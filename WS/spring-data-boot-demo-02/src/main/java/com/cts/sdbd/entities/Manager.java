package com.cts.sdbd.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("M")
//@Table(name="mgrs")
@Table(name="mgrs_only")
public class Manager extends Employee {

	private Double allowence;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(Long empId, String fullName, Double basic, Double allowence) {
		super(empId, fullName, basic);
		this.allowence = allowence;
	}

	public Double getAllowence() {
		return allowence;
	}

	public void setAllowence(Double allowence) {
		this.allowence = allowence;
	}

}
