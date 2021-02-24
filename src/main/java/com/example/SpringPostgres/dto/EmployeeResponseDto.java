package com.example.SpringPostgres.dto;

import com.example.SpringPostgres.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeResponseDto {
    private long id;

    private String name;

    private DepartmentResponseDto department;
    public void setDepartmentFromEntity(Department departmentEntity)
    {
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setId(departmentEntity.getId());
        departmentResponseDto.setDepartmentName(departmentEntity.getDepartmentName());
        this.department =departmentResponseDto;

    }
}
