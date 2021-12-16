package com.cts.sdbd.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="depts")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="dept_id")
	private Long deptId;
	
	@Column(name="d_title",nullable = false,unique = true)
	private String title;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "dept")
	private Set<Employee> employees;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long deptId, String title, Set<Employee> employees) {
		super();
		this.deptId = deptId;
		this.title = title;
		this.employees = employees;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", title=" + title + "]";
	}
	
	
}
