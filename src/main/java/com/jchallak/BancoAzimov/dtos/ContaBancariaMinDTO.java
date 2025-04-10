package com.jchallak.BancoAzimov.dtos;

import com.jchallak.BancoAzimov.entities.Transacao;

import java.util.ArrayList;
import java.util.List;

public class ContaBancariaMinDTO {

    private Long id;
    private String numeroConta;


    public ContaBancariaMinDTO(Long id, String numeroConta) {
        this.id = id;
        this.numeroConta = numeroConta;

    }

    public ContaBancariaMinDTO() {
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


}
