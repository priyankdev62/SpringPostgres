package com.example.SpringPostgres.service;

import com.example.SpringPostgres.dto.EmployeeRequestDto;
import com.example.SpringPostgres.dto.EmployeeResponseDto;
import com.example.SpringPostgres.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto saveDetails(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto findById(Long id);
    EmployeeResponseDto updateEmployee(Long id,EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto deleteById(Long id);
    List<EmployeeResponseDto> getEmployeeListByDepartment(Long departmentId);


}
