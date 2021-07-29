package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankResponseDto  {
	private List<BankDetailsDto> bankDetails = new ArrayList<>();

	public BankDetailsDto addBankDetails(BankDetailsDto bankDetailsDto) {
		this.bankDetails.add(bankDetailsDto);
		return bankDetailsDto;
	}
}
