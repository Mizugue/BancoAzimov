package com.jchallak.BancoAzimov.dtos.userDTOs;

public class UserRegisterDTO {

    private String username;
    private String senha;
    private String email;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String username, String senha, String email) {
        this.username = username;
        this.senha = senha;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
