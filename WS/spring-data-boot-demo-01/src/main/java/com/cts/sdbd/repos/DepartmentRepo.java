package com.cts.sdbd.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.sdbd.entities.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
