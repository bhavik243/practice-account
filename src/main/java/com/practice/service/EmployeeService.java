package com.practice.service;

import com.practice.dto.EmployeeDto;
import com.practice.response.Response;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployeeDetails();

    EmployeeDto getEmployeeById(int id);

}
