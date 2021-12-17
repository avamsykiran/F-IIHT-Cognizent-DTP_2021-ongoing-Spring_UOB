package com.cts.sdbd.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emps")
public class Employee implements Comparable<Employee>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eid")
	private Long empId;
	
	@Column(name="full_name",nullable = false)
	private String fullName;
	
	private Double basic;
	
	@Embedded
	private Address address;
	
	@ManyToOne
	@JoinColumn
	private Department dept;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "holder")
	private BankAccount salAccount;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String fullName, Double basic, Address address, Department dept,
			BankAccount salAccount) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.basic = basic;
		this.address = address;
		this.dept = dept;
		this.salAccount = salAccount;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public BankAccount getSalAccount() {
		return salAccount;
	}

	public void setSalAccount(BankAccount salAccount) {
		this.salAccount = salAccount;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", basic=" + basic + ", address=" + address
				+ ", dept=" + dept + ", salAccount=" + salAccount + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.empId!=null?this.empId.compareTo(o.empId):1;
	}
}
