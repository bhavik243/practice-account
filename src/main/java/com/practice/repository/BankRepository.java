package com.practice.repository;

import com.practice.entity.Account;
import com.practice.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer>{

	ResponseEntity<Object> getById(Account account);

}
