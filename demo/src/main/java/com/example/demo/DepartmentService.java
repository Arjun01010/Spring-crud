package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    // save operation
    Department saveDepartment(Department department);

    // read operation
    List<Department> fetchDepartmentList();

    // update operation
    Department updateDepartment(Department department, Long departmentId);

    // delete operation
    void deleteDepartmentById(Long departmentId);

    List<Department> fetchDepartmentById();
}

