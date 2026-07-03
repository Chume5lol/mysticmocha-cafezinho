package com.mysticmocha_cafezinho.mysticmocha_cafezinho.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Users;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.service.JwtService;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.service.UserDetailsServiceIml;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceIml userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String auth = request.getHeader("Authorization");

        if(auth == null || !auth.startsWith("Bearer ")){

            filterChain.doFilter(request,response);
            return;
        }

        String token = auth.substring(7);

        String nickname = jwtService.extractUsername(token);

        if(nickname != null &&
            SecurityContextHolder.getContext().getAuthentication()==null){

            UserDetails user =
                    userDetailsService.loadUserByUsername(nickname);

            if(jwtService.isTokenValid(token,(Users)user)){

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                user,
                                null,
                                user.getAuthorities());

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request,response);
    }
}