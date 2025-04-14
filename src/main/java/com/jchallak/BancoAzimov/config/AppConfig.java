package com.jchallak.BancoAzimov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.security.Security;

@Configuration
public class AppConfig {


    @Bean
    @Primary
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}


}
