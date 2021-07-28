package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankResponseDto {

	private int id;
	private String name;
	private int accountNumber;
	private int bankName;
	private long count;

}
