package com.cts.sdbd.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("C")
//@Table(name="cemps")
@Table(name="cemps_only")
public class ContractEmployee extends Employee{

	private Integer duration;
	
	public ContractEmployee() {
		// TODO Auto-generated constructor stub
	}

	public ContractEmployee(Long empId, String fullName, Double basic,Integer duration) {
		super(empId, fullName, basic);
		this.duration=duration;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
}
