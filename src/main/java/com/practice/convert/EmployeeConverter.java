package com.practice.convert;

import com.practice.dto.EmployeeDto;
import com.practice.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public final class EmployeeConverter {

    public static List<EmployeeDto> convertToDtoList(List<Employee> employeeList) {
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        if (!(employeeList == null || employeeList.isEmpty())) {
            for (Employee employee : employeeList) {
                employeeDtos.add(convertToDto(employee));
            }
        }
        return employeeDtos;
    }

    public static EmployeeDto convertToDto(Employee employee) {
        if(employee == null) {
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getEmployeeName(), employee.getSalary(), employee.getDeptId());
        return employeeDto;
    }

}
