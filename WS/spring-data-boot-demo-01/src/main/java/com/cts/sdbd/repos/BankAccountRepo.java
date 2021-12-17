package com.cts.sdbd.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.sdbd.entities.BankAccount;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount,String>{

}
