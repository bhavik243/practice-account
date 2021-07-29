package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankCodeRequestDto {
    @NotNull(message = "bankCode values cannot be empty")
    private List<Integer> bankCodes;

}
