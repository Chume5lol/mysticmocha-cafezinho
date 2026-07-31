package com.mysticmocha_cafezinho.mysticmocha_cafezinho.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Department;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department createDepartment(String name){

        Department department = new Department();
        department.setName(name);
        return departmentRepository.save(department);
    }

    public List<Department> findDepartments() {

        return departmentRepository.findAll();
    }
}
