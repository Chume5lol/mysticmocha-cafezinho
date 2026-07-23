package com.mysticmocha_cafezinho.mysticmocha_cafezinho.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Department;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Users;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.UserDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.UserResponseDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.DepartmentRepository;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;

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
            user.setLastLogin(null);
            user.setRole(userDTO.getUserRole());

            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Dados para criação incorretos");
        }

    }

     public List<UserResponseDTO> formartUserDTO(Page<Users> users) {
        return users
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getFistName(),
                        user.getLastName(),
                        user.getNickname(),
                        user.getEmail(),
                        user.getDepartment().getName(),
                        user.getUserRole().name(),
                        user.getLastLogin() != null ? user.getLastLogin().toString() : "Indefinido",
                        user.getEnable()))
                .toList();
    }

    public List<UserResponseDTO> findAll(int pageNumber, int quantityItens) {

        try {
            Pageable pageable = PageRequest.of(pageNumber, quantityItens);
            Page<Users> usersPageable = userRepository.findAll(pageable);
            List<UserResponseDTO> users = formartUserDTO(usersPageable);
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Long countAllUsers() {
        return userRepository.count()/10;
    }
}
