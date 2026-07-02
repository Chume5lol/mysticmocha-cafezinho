package com.mysticmocha_cafezinho.mysticmocha_cafezinho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.UserRepository;

@Service
public class UserDetailsServiceIml implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nickname)
            throws UsernameNotFoundException {

        return userRepository.findByNickname(nickname).orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado"));
    }



}
