package com.example.SpringPostgres.repository;

import com.example.SpringPostgres.entity.Department;
import com.example.SpringPostgres.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    List<Employee> findByDepartment(Department department);
    List<Employee> findByDepartment_Id(Long departmentId);
    @Query("Select e FROM febemployee e WHERE e.department.id = ?1")
    List<Employee> findEmployeeListByDepartmentId(long departmentId);

    @Query(value ="SELECT * FROM febemployee e WHERE e.department_id = ?1",nativeQuery = true)
    List<Employee> findEmployeeListByNativeQuery(long departmentId);//using native query

 }
