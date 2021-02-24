package com.example.SpringPostgres.controller;

import com.example.SpringPostgres.dto.DepartmentRequestDto;
import com.example.SpringPostgres.dto.DepartmentResponseDto;
import com.example.SpringPostgres.entity.Department;
import com.example.SpringPostgres.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public DepartmentResponseDto createDepartment(@RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.createDepartment(departmentRequestDto);
    }
    @GetMapping(value ="/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id)
    {
        return departmentService.getDepartmentById(id);
    }
    @PutMapping(value = "/{id}")
    public DepartmentResponseDto updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentRequestDto departmentRequestDto)
    {
        return departmentService.updateDepartment(departmentId, departmentRequestDto);
    }
}
