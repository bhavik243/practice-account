package com.practice.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String bankName;
	@Column(name = "is_deleted")
	private boolean isDeleted;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "modified_date")
	private Date modifiedDate;

}

