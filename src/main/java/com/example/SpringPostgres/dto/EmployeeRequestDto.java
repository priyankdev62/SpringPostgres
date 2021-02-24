package com.example.SpringPostgres.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {
    private Long id;

    private String name;

   // private String departmentName;

    private DepartmentRequestDto department;
}
