package com.jchallak.BancoAzimov.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private TipoTransacao transacao;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "conta_origem_id")
    private ContaBancaria contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino_id")
    private ContaBancaria contaDestino;

    public Transacao(Long id, Double valor, LocalDateTime dataHora, TipoTransacao transacao, String descricao, ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
        this.transacao = transacao;
        this.descricao = descricao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public Transacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public TipoTransacao getTransacao() {
        return transacao;
    }

    public void setTransacao(TipoTransacao transacao) {
        this.transacao = transacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ContaBancaria getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaBancaria contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaBancaria getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaBancaria contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao1 = (Transacao) o;
        return Objects.equals(id, transacao1.id) && Objects.equals(valor, transacao1.valor) && Objects.equals(dataHora, transacao1.dataHora) && transacao == transacao1.transacao && Objects.equals(descricao, transacao1.descricao) && Objects.equals(contaOrigem, transacao1.contaOrigem) && Objects.equals(contaDestino, transacao1.contaDestino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, dataHora, transacao, descricao, contaOrigem, contaDestino);
    }
}
