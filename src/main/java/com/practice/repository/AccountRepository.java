package com.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.practice.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{

	Optional<Account> findByIbanNumber(int ibanNumber);

	ResponseEntity<Object> getById(Account account);
}
