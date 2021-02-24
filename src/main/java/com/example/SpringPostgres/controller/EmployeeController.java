package com.example.SpringPostgres.controller;


import com.example.SpringPostgres.dto.EmployeeRequestDto;
import com.example.SpringPostgres.dto.EmployeeResponseDto;
import com.example.SpringPostgres.entity.Employee;
import com.example.SpringPostgres.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //POST - /employee
    @PostMapping
    public EmployeeResponseDto saveDetails(@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.saveDetails(employeeRequestDto);
    }

    //GET - /employee/{id}
    @GetMapping(value = "/{id}")
    public EmployeeResponseDto findById (@PathVariable("id") long id){
        return employeeService.findById(id);

    }
    @PutMapping(value = "/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable("id") long id,@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.updateEmployee(id,employeeRequestDto);
    }

    //PUT - /employee/{id}
    @DeleteMapping(value ="/{id}")
    public  EmployeeResponseDto deleteById(@PathVariable("id") long id)
    {
        return employeeService.deleteById(id);
    }
    //DELETE - /employee/{id}
    @GetMapping(value =  "/department/{id}")
    public List<EmployeeResponseDto> getEmployeeListByDepartment(@PathVariable("id") long departmentId)
    {
        return employeeService.getEmployeeListByDepartment(departmentId);
    }
}