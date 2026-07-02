package com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
