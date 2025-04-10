package com.jchallak.BancoAzimov.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_conta_bancaria")
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroConta;

    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "contaOrigem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transacao> transacoesOrigem = new ArrayList<>();

    @OneToMany(mappedBy = "contaDestino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transacao> transacoesDestino = new ArrayList<>();


    public ContaBancaria(Long id, String numeroConta, Double saldo, User user, List<Transacao> transacoesOrigem, List<Transacao> transacoesDestino) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.user = user;
        this.transacoesOrigem = transacoesOrigem;
        this.transacoesDestino = transacoesDestino;
    }

    public ContaBancaria() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
