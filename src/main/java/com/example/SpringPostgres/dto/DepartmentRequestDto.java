package com.example.SpringPostgres.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRequestDto {
    private Long id;
    private String departmentName;
    private String departmentCode;

}

