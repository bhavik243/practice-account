package com.practice.service.impl;

import com.practice.constants.CommonConstants;
import com.practice.dto.BankDetailsDto;
import com.practice.dto.BankResponseDto;
import com.practice.entity.Bank;
import com.practice.repository.BankRepository;
import com.practice.response.DataResponse;
import com.practice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    //@Autowired
    //BankRepository bankRepository;

    @Autowired
    MessageSource messageSource;

    @Override
    public DataResponse getBankNames(List<Integer> bankCodes) {

        List<Bank> banks = new ArrayList<Bank>();  //bankRepository.findAllById(bankCodes);

        BankResponseDto responseDTO = new BankResponseDto();
        for(Bank bank: banks) {
            BankDetailsDto bankDetailsDto = responseDTO.addBankDetails(new BankDetailsDto());
            bankDetailsDto.setBankCode(bank.getId());
            bankDetailsDto.setBankName(bank.getBankName());
        }
        return new DataResponse(HttpStatus.OK.value(),
                messageSource.getMessage(CommonConstants.SUCCESS, null, LocaleContextHolder.getLocale()),HttpStatus.OK, responseDTO);
    }
}
