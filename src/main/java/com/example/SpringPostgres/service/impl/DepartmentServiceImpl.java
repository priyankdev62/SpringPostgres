package com.example.SpringPostgres.service.impl;

import com.example.SpringPostgres.dto.DepartmentRequestDto;
import com.example.SpringPostgres.dto.DepartmentResponseDto;
import com.example.SpringPostgres.entity.Department;
import com.example.SpringPostgres.repository.DepartmentRepository;
import com.example.SpringPostgres.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl  implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto){
        Department department = new Department();
        BeanUtils.copyProperties(departmentRequestDto,department);
        Department savedDepartment =departmentRepository.save(department);
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        BeanUtils.copyProperties(savedDepartment, departmentResponseDto);
        return departmentResponseDto;
    }
    @Override
    public Department getDepartmentById(long id){
        return departmentRepository.findById(id).get();
    }
}
