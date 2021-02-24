package com.example.SpringPostgres.service;

import com.example.SpringPostgres.dto.DepartmentRequestDto;
import com.example.SpringPostgres.dto.DepartmentResponseDto;
import com.example.SpringPostgres.entity.Department;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);
    Department getDepartmentById(long id);
}
