package com.practice.controller;

import java.util.List;

import com.practice.dto.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.FavouriteAccount;
import com.practice.service.AccountService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping(path = "/add/{Number}")
	@ApiOperation(value = "Add a new account", notes = "Create an new account for customer.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	public ResponseEntity<Object> addNewAccount(@RequestBody AccountRequest accountRequest) {
		return accountService.addNewAccount(accountRequest);
	}
	
	@GetMapping(path = "/{ibanNumber}")
	@ApiOperation(value = "Get account details", notes = "Find account details by iban number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	public ResponseEntity<Object> getByIbanNumber(@PathVariable int ibanNumber) {
		return accountService.findByIbanNumber(ibanNumber);
	}

	@PutMapping(path = "/accountdetails")
	@ApiOperation(value = "Updating favouriteAccount details", notes = "updating details.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	public ResponseEntity<Object> updateAccount(@RequestBody FavouriteAccount favouriteAccount) {
          return accountService.updateAccount(favouriteAccount);
	}

	@GetMapping(path = "/Accounts/{ibanNumber}")
	@ApiOperation(value = "Get all accounts", notes = "Get all Accounts by iban number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	public List<FavouriteAccount> deleteAccountsByIbanNumber(@PathVariable Integer IbanNumber) {

		return accountService.deleteAccountsByIbanNumber(IbanNumber);
	}
	
	
	}

