package com.practice.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.practice.entity.Account;
import com.practice.entity.Bank;

public interface AccountService {


	public ResponseEntity<Object> addNewAccount(Account account);

	public ResponseEntity<Object> findByIbanNumber(int ibanNumber);

	public ResponseEntity<Object> accountDetails(Account account, int ibanNumber);

	public ResponseEntity<Object> updateAccount(Account account);

	public List<Account> findAccountsByIbanNumber(Integer ibanNumber);

	public List<Account> deleteAccountsByIbanNumber(Integer ibanNumber);

	public List<Bank> getAllAccounts(int pageNumber, int pageSize);

	

}
