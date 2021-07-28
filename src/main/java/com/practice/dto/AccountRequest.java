package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class AccountRequest {

    private Integer id;
    private String name;
    private String accountNumber;
    private String bankName;
}
