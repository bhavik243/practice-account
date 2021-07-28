package com.practice.service.impl;

import java.util.List;
import java.util.Optional;

import com.practice.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.entity.Account;
import com.practice.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	public ResponseEntity<Object> addNewAccount(Account account) {

		accountRepository.save(account);

		return ResponseEntity.status(HttpStatus.CREATED).body("New Account created successfully.");
	}

	public ResponseEntity<Object> findByIbanNumber(int ibanNumber) {
		Optional<Account> accountEntityOpt = accountRepository.findByIbanNumber(ibanNumber);

		if (accountEntityOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Iban Number" + ibanNumber + " found.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Iban Number " + ibanNumber + " not found.");
		}
	}

	/*
	 * @Override public ResponseEntity<Object> updateAccount(Account account) {
	 * Optional<Account> favourite = accountRepository.findById(account.getId());
	 * 
	 * if (favourite.isPresent()) { Account account= account.getAccountName();
	 * account.setAccountName(account.getAccountName());
	 * 
	 * account = accountRepository.save(account);
	 * 
	 * return account; } else { account = accountRepository.save(account);
	 * 
	 * return account; }
	 * 
	 * }
	 */

	public List<Account> findAccountsByIbanNumber(Integer ibanNumber) {
		 accountRepository.deleteById(ibanNumber);;
		return null;
	}

	@Override
	public ResponseEntity<Object> accountDetails(Account account, int ibanNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> deleteAccountsByIbanNumber(Integer ibanNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bank> getAllAccounts(int pageNumber, int pageSize) {
		return null;
	}

	/*
	 * @Override public List<Account> deleteAccountsByIbanNumber(Integer ibanNumber)
	 * {
	 * 
	 * return null; }
	 */
	/*
	 * @Override public ResponseEntity<Object> accountDetails(Account account, int
	 * ibanNumber) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public ResponseEntity<Object> updateAccount(Account account) { //
	 * TODO Auto-generated method stub return null; }
	 */


	}

	


