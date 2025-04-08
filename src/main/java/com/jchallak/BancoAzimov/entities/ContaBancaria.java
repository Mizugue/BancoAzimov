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

    @OneToMany(mappedBy = "contaOrigem")
    private List<Transacao> transacoesEnviadas = new ArrayList<>();

    @OneToMany(mappedBy = "contaDestino")
    private List<Transacao> transacoesRecebidas = new ArrayList<>();

    public ContaBancaria(Long id, String numeroConta, Double saldo, User user) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.user = user;
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


}
