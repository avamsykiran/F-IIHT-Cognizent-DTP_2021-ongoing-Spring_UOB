package com.cts.sdbd.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.sdbd.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{

}
