package com.mysticmocha_cafezinho.mysticmocha_cafezinho.service;

import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Department;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Users;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.UserRole;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.UserDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.DepartmentRepository;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    public Users registerUser(UserDTO userDTO) {

        try {
            Department department = departmentRepository.findById(userDTO.getDepartment()).orElseThrow();
            String encryptedPassword = new BCryptPasswordEncoder().encode(userDTO.getPassword());

            Users user = new Users();
            user.setFistName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setNickname(userDTO.getNickname());
            user.setEmail(userDTO.getEmail());
            user.setDepartment(department);
            user.setPassword(encryptedPassword);
            user.setEnable();
            user.setLastLogin(LocalDateTime.now());
            user.setRole(UserRole.ADMINISTRATOR);

            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeErrorException(null, e.getMessage());
        }

    }
}
