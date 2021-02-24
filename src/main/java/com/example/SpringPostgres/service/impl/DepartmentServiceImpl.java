package com.example.SpringPostgres.service.impl;

import com.example.SpringPostgres.dto.DepartmentRequestDto;
import com.example.SpringPostgres.dto.DepartmentResponseDto;
import com.example.SpringPostgres.entity.Department;
import com.example.SpringPostgres.entity.Employee;
import com.example.SpringPostgres.repository.DepartmentRepository;
import com.example.SpringPostgres.repository.EmployeeRepository;
import com.example.SpringPostgres.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceImpl  implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
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
    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }
    @Transactional
    @Override
    public DepartmentResponseDto updateDepartment(Long departmentId,DepartmentRequestDto departmentRequestDto){
        Department department = departmentRepository.findById(departmentId).get();
        List<Employee> employeeList = employeeRepository.findByDepartment_Id(departmentId);
        department.setDepartmentName(departmentRequestDto.getDepartmentName());
        Department savedDepartment = departmentRepository.save(department);
        employeeList.forEach(employee -> {
            employee.setEmployeeCode(departmentRequestDto.getDepartmentCode());

        });
        DepartmentResponseDto departmentResponseDto =  new DepartmentResponseDto();
        BeanUtils.copyProperties(savedDepartment,departmentResponseDto);
        return departmentResponseDto;
    }
}
