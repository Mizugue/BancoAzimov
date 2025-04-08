package com.jchallak.BancoAzimov.Utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppUtils {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
