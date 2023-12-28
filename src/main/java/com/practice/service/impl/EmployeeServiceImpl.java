package com.practice.service.impl;

import com.practice.convert.EmployeeConverter;
import com.practice.dto.EmployeeDto;
import com.practice.entity.Employee;
import com.practice.repository.EmployeeRepository;
import com.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployeeDetails() {
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeConverter.convertToDtoList(employees);
    }

    @Override
    public EmployeeDto getEmployeeById(int id) {
        Employee employee = employeeRepository.getById(id);
        return EmployeeConverter.convertToDto(employee);
    }
}
