package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

// Class
public interface DepartmentRepository
        extends CrudRepository<Department, Long> {
}
