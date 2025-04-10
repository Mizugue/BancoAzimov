package com.jchallak.BancoAzimov.dtos;

import com.jchallak.BancoAzimov.entities.ContaBancaria;
import com.jchallak.BancoAzimov.entities.Role;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UserMinDTO {

    private Long id;
    private String email;
    private String username;
    private Boolean ativo;

    public UserMinDTO() {
    }

    public UserMinDTO(Long id, String email, String username, Boolean ativo) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
