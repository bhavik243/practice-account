package com.practice.service;

import java.util.List;

import com.practice.dto.AccountRequest;
import com.practice.entity.FavouriteAccount;
import org.springframework.http.ResponseEntity;

import com.practice.entity.Bank;

public interface AccountService {

	public ResponseEntity<Object> addNewAccount(AccountRequest account);

	public ResponseEntity<Object> findByIbanNumber(int ibanNumber);

	public ResponseEntity<Object> accountDetails(FavouriteAccount favouriteAccount, int ibanNumber);

	public ResponseEntity<Object> updateAccount(FavouriteAccount favouriteAccount);

	public List<FavouriteAccount> findAccountsByIbanNumber(Integer ibanNumber);

	public List<FavouriteAccount> deleteAccountsByIbanNumber(Integer ibanNumber);

	public List<Bank> getAllAccounts(int pageNumber, int pageSize);

	

}
