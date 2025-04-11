package com.jchallak.BancoAzimov.dtos;

import com.jchallak.BancoAzimov.dtos.userDTOs.UserMinDTO;

public class ContaBancariaDTO {


    private Long id;
    private String numeroConta;
    private UserMinDTO user;


    public ContaBancariaDTO(Long id, String numeroConta, UserMinDTO user) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.user = user;

    }

    public ContaBancariaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public UserMinDTO getUser() {
        return user;
    }

    public void setUser(UserMinDTO user) {
        this.user = user;
    }


}
