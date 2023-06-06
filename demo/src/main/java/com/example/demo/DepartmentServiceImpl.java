package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    // save operation
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Iterable<Department> saveAllDepartment(List<Department> department) {
        return departmentRepository.saveAll(department);
    }

    // read operation
    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>) departmentRepository.findAll();
    }

    // update operation
    @Override
    public Department updateDepartment(Department department, Long isbnId) {
        Department depDB = departmentRepository.findById(isbnId).get();

        if (Objects.nonNull(department.getUrl()) && !"".equalsIgnoreCase(department.getUrl())) {
            depDB.setUrl(department.getUrl());
        }

        // if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
        //     depDB.setDepartmentAddress(department.getDepartmentAddress());
        // }

        // if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
        //     depDB.setDepartmentCode(department.getDepartmentCode());
        // }

        return departmentRepository.save(depDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Optional<Department> fetchDepartmentById(Long isbnId) {

        return departmentRepository.findById(isbnId);
    }

    @Override
    public String fetchTitle(Long isbnId) {
        Optional<Department> temp = departmentRepository.findById(isbnId);
        //temp = departmentRepository.findById(isbnId);
        //String title = temp.get('URL')
        return "string";
    }

}

