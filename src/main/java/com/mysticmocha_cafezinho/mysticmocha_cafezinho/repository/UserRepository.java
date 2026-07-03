package com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

    Optional<Users> findByNickname(String nickname);
}
