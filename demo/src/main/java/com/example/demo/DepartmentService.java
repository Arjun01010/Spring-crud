package com.example.demo;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    // save operation
    Department saveDepartment(Department department);

    Iterable<Department> saveAllDepartment(List<Department> department);

    // read operation
    List<Department> fetchDepartmentList();

    // update operation
    Department updateDepartment(Department department, Long departmentId);

    // delete operation
    void deleteDepartmentById(Long departmentId);

    Optional<Department> fetchDepartmentById(Long isbnId);

    String fetchTitle(Long isbnId);
}

