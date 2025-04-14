package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.entities.User;
import com.jchallak.BancoAzimov.repositories.UserRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AuthenticatedUserService {

    @Autowired
    private UserRepository userRepository;

    protected User authenticated() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwt = (Jwt) authentication.getPrincipal();
            String username = jwt.getClaim("username");
            return userRepository.findByUsername(username).get();
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
