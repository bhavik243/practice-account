package com.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "favourite_account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "account_name")
	private String accountName;
	@Column(name = "iban_number")
	private int ibanNumber;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "account_status_id")
	private int accountStatusId;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "modified_date")
	private Date modifiedDate;

}
