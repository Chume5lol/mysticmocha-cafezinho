package com.mysticmocha_cafezinho.mysticmocha_cafezinho.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.UserRepository;

@Service
public class UserDetailsServiceIml implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) {

        System.out.println("Recebi nickname: " + nickname);

        return userRepository.findByNickname(nickname)
                .map(UserAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
