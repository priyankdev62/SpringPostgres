package com.example.SpringPostgres.service;

import com.example.SpringPostgres.dto.EmployeeRequestDto;
import com.example.SpringPostgres.dto.EmployeeResponseDto;
import com.example.SpringPostgres.entity.Employee;

public interface EmployeeService {
    EmployeeResponseDto saveDetails(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto findById(long id);
    EmployeeResponseDto updateEmployee(long id,EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto deleteById(long id);


}
