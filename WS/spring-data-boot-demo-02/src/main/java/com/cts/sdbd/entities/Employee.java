package com.cts.sdbd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
/*@Table(name="all_emps")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="etype",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("E")*/
/*@Table(name="emps")
@Inheritance(strategy = InheritanceType.JOINED)*/
@Table(name="emps_only")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="eid")
	private Long empId;
	
	@Column(name="full_name",nullable = false)
	private String fullName;
	
	private Double basic;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String fullName, Double basic) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.basic = basic;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	
}
