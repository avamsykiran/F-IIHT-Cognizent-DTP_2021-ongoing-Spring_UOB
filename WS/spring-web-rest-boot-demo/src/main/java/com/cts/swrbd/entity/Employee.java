package com.cts.swrbd.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="emps")
@XmlRootElement
public class Employee {

	@Id
	@Column(name="eid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	@Column(name="fnm",nullable = false)
	@NotBlank(message = "Full Name is a mandatory field")
	private String fullName;
	
	@NotNull(message ="Join Date is a mandatory field")
	@PastOrPresent(message = "Join Date can not be a future date")
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="jdt",nullable = false)
	private LocalDate joinDate;
	
	@NotNull(message ="Salary is a mandatory field")
	@Min(value = 2000,message = "Salary can not be less than 2000")
	@Max(value=100000,message="Salary can not be more than 100000" )
	@Column(name="sal",nullable = false)
	private Double salary;
	
	public Employee(){}

	public Employee(Long empId, String fullName, LocalDate joinDate, Double salary) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.joinDate = joinDate;
		this.salary = salary;
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

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
