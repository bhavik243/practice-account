package com.practice.service.impl;

import java.util.List;
import java.util.Optional;

import com.practice.dto.AccountRequest;
import com.practice.entity.Bank;
import com.practice.entity.FavouriteAccount;
import com.practice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	public ResponseEntity<Object> addNewAccount(AccountRequest accountRequest) {

		FavouriteAccount favouriteAccount = new FavouriteAccount();
		favouriteAccount.setAccountName(accountRequest.getName());

		accountRepository.save(favouriteAccount);

		return ResponseEntity.status(HttpStatus.CREATED).body("New FavouriteAccount created successfully.");
	}

	public ResponseEntity<Object> findByIbanNumber(int ibanNumber) {
		Optional<FavouriteAccount> accountEntityOpt = accountRepository.findByIbanNumber(ibanNumber);

		if (accountEntityOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Iban Number" + ibanNumber + " found.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Iban Number " + ibanNumber + " not found.");
		}
	}

	/*
	 * @Override public ResponseEntity<Object> updateAccount(FavouriteAccount account) {
	 * Optional<FavouriteAccount> favourite = accountRepository.findById(account.getId());
	 * 
	 * if (favourite.isPresent()) { FavouriteAccount account= account.getAccountName();
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

	public List<FavouriteAccount> findAccountsByIbanNumber(Integer ibanNumber) {
		 accountRepository.deleteById(ibanNumber);;
		return null;
	}

	@Override
	public ResponseEntity<Object> accountDetails(FavouriteAccount favouriteAccount, int ibanNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> updateAccount(FavouriteAccount favouriteAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FavouriteAccount> deleteAccountsByIbanNumber(Integer ibanNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bank> getAllAccounts(int pageNumber, int pageSize) {
		return null;
	}

	/*
	 * @Override public List<FavouriteAccount> deleteAccountsByIbanNumber(Integer ibanNumber)
	 * {
	 * 
	 * return null; }
	 */
	/*
	 * @Override public ResponseEntity<Object> accountDetails(FavouriteAccount account, int
	 * ibanNumber) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public ResponseEntity<Object> updateAccount(FavouriteAccount account) { //
	 * TODO Auto-generated method stub return null; }
	 */


	}

	


