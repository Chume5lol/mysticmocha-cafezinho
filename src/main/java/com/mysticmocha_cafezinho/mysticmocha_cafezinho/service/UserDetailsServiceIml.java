package com.mysticmocha_cafezinho.mysticmocha_cafezinho.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceIml implements UserDetailsService {

    private final UserRepository userRepository;

    //Decide como vai fazer login de usuário, no caso está pegando o nickname + password
    @Override
    public UserDetails loadUserByUsername(String nickname) {

        return userRepository.findByNickname(nickname)
                .map(UserAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
