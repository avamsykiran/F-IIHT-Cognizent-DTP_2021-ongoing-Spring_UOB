package com.cts.sdbd;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.sdbd.entities.Address;
import com.cts.sdbd.entities.BankAccount;
import com.cts.sdbd.entities.Department;
import com.cts.sdbd.entities.Employee;
import com.cts.sdbd.repos.DepartmentRepo;
import com.cts.sdbd.repos.EmployeeRepo;

@SpringBootApplication
public class SpringDataBootDemo01Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDataBootDemo01Application.class, args);
	}

	@Autowired
	private DepartmentRepo deptRepo;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		if(deptRepo.count()==0) {
			Department javaDept = new Department(null, "Java FSD", new TreeSet<>());
			
			Employee e1 = new Employee(null, "Vamsy", 45678.0, 
					new Address("4-16/1", "VSP"), javaDept,null); 
			e1.setSalAccount(new BankAccount("SB001", "SBI0090", "SBI", e1));

			Employee e2 = new Employee(null, "Srinu", 45678.0, 
					new Address("4-16/1", "HYD"), javaDept,null); 
			e2.setSalAccount(new BankAccount("SB0045", "SBI0090", "SBI", e2));
			
			javaDept.getEmployees().add(e1);
			javaDept.getEmployees().add(e2);
			
			Department accountsDept = new Department(null, "Accounts", new TreeSet<>());
			Department hrDept = new Department(null, "HR", new TreeSet<>());
			
			deptRepo.save(javaDept);
			deptRepo.save(accountsDept);
			deptRepo.save(hrDept);
			
			System.out.println("Hypothetical data inserted!");
		}else {
			deptRepo.findAll().stream().forEach(System.out::println);
			empRepo.findAll().stream().forEach(System.out::println);
		}
	}

}
