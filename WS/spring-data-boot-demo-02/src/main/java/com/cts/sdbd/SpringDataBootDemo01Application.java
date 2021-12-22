package com.cts.sdbd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.sdbd.entities.ContractEmployee;
import com.cts.sdbd.entities.Employee;
import com.cts.sdbd.entities.Manager;
import com.cts.sdbd.repos.EmployeeRepo;

@SpringBootApplication
public class SpringDataBootDemo01Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDataBootDemo01Application.class, args);
	}

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Employee e = new Employee(null,"Vamsy",5678.0);
		Manager m = new Manager(null, "Suseela", 6789.0, 789.99);
		ContractEmployee ce = new ContractEmployee(null, "Srinu", 4678.0, 15);
		
		empRepo.save(e);
		empRepo.save(m);
		empRepo.save(ce);
		System.out.println("Hypothetical data inserted");
	}

}
