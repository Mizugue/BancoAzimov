package com.jchallak.BancoAzimov.dtos;

import com.jchallak.BancoAzimov.entities.ContaBancaria;
import com.jchallak.BancoAzimov.entities.Role;
import com.jchallak.BancoAzimov.entities.User;
import jakarta.persistence.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {


    private Long id;
    private String email;
    private String username;
    private String senha;
    private Boolean ativo;
    private LocalDateTime criadoEm;
    private Set<ContaBancariaMinDTO> contasBancarias = new HashSet<>();
    private Set<Role> roles = new HashSet<>();

    public UserDTO(Long id, String email, String username, String senha, Boolean ativo, LocalDateTime criadoEm, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.ativo = ativo;
        this.criadoEm = criadoEm;
        this.roles = roles;
    }

    public static UserDTO fromEntity(User user, ModelMapper modelMapper){
        UserDTO userDTO = new UserDTO(user.getId(), user.getEmail(), user.getUsername(), user.getSenha(), user.getAtivo(), user.getCriadoEm(), user.getRoles());
        userDTO.setContasBancarias(user.getContasBancarias().stream().map(conta -> modelMapper.map(conta, ContaBancariaMinDTO.class)).collect(Collectors.toSet()));
        return userDTO;
    }

    public UserDTO() {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Set<ContaBancariaMinDTO> getContasBancarias() {
        return contasBancarias;
    }

    public void setContasBancarias(Set<ContaBancariaMinDTO> contasBancarias) {
        this.contasBancarias = contasBancarias;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + ativo +
                ", criadoEm=" + criadoEm +
                ", contasBancarias=" + contasBancarias +
                ", roles=" + roles +
                '}';
    }
}
