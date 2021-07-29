package com.practice.service;

import com.practice.entity.FavouriteAccount;
import com.practice.response.Response;

import java.util.List;

public interface BankService {

    Response getBankNames(List<Integer> ibans);
}
