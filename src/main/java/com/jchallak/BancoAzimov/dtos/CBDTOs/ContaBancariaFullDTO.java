package com.jchallak.BancoAzimov.dtos.CBDTOs;

import com.jchallak.BancoAzimov.dtos.TransacaoMinDTO;
import com.jchallak.BancoAzimov.entities.ContaBancaria;
import com.jchallak.BancoAzimov.entities.Transacao;
import com.jchallak.BancoAzimov.entities.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContaBancariaFullDTO {

    private Long id;
    private String numeroConta;
    private Double saldo;
    private List<Transacao> transacoesOrigem = new ArrayList<>();
    private List<Transacao> transacoesDestino = new ArrayList<>();

    public void fromEntity (ContaBancaria contaBancaria){
        this.id = contaBancaria.getId();
        this.numeroConta = contaBancaria.getNumeroConta();
        this.saldo = contaBancaria.getSaldo();
        this.transacoesOrigem = contaBancaria.getTransacoesOrigem().stream().map(x -> new TransacaoMinDTO(x));
        this.transacoesDestino = contaBancaria.getTransacoesDestino().stream().map(x -> new TransacaoMinDTO(x));
    }

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

    public List<Transacao> getTransacoesOrigem() {
        return transacoesOrigem;
    }

    public void setTransacoesOrigem(List<Transacao> transacoesOrigem) {
        this.transacoesOrigem = transacoesOrigem;
    }

    public List<Transacao> getTransacoesDestino() {
        return transacoesDestino;
    }

    public void setTransacoesDestino(List<Transacao> transacoesDestino) {
        this.transacoesDestino = transacoesDestino;
    }
}
