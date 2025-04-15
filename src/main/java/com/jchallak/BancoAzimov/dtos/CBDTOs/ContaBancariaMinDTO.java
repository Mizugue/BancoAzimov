package com.jchallak.BancoAzimov.dtos.CBDTOs;

public class ContaBancariaMinDTO {

    private String numeroConta;


    public ContaBancariaMinDTO(Long id, String numeroConta) {
        this.numeroConta = numeroConta;

    }

    public ContaBancariaMinDTO() {
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }


}
