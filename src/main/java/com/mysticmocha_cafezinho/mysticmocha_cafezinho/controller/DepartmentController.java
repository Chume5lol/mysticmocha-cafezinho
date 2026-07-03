package com.mysticmocha_cafezinho.mysticmocha_cafezinho.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Department;

@RequestMapping(name = "department")
@RestController
public class DepartmentController {


    public ResponseEntity<Department> registerDepartment(@RequestBody String nome) {
        return ResponseEntity.ok(null);
    }
}
