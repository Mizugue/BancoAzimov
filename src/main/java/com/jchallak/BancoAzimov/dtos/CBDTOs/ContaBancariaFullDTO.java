package com.jchallak.BancoAzimov.dtos.CBDTOs;

import com.jchallak.BancoAzimov.dtos.transDTOs.TransacaoMinDTO;


import java.util.ArrayList;
import java.util.List;


public class ContaBancariaFullDTO {

    private Long id;
    private String numeroConta;
    private Double saldo;
    private List<TransacaoMinDTO> transacoesOrigem = new ArrayList<>();
    private List<TransacaoMinDTO> transacoesDestino = new ArrayList<>();


    public ContaBancariaFullDTO() {
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<TransacaoMinDTO> getTransacoesOrigem() {
        return transacoesOrigem;
    }

    public void setTransacoesOrigem(List<TransacaoMinDTO> transacoesOrigem) {
        this.transacoesOrigem = transacoesOrigem;
    }

    public List<TransacaoMinDTO> getTransacoesDestino() {
        return transacoesDestino;
    }

    public void setTransacoesDestino(List<TransacaoMinDTO> transacoesDestino) {
        this.transacoesDestino = transacoesDestino;
    }
}

