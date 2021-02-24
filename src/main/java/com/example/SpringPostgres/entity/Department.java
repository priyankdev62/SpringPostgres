package com.example.SpringPostgres.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name="febDepartment")
@Getter
@Setter
public class Department {
    @Id
    @GenericGenerator(name ="department_id_seq",strategy="increment")
    @GeneratedValue(generator = "department_id_seq",strategy= GenerationType.AUTO)
    private Long id;
    private String departmentName;

//    @JoinColumn(referencedColumnName = "id",name ="department_id")
//    @OneToMany
//    List<Employee> employeeList;
}
