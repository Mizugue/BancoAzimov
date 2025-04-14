package com.jchallak.BancoAzimov.dtos;

import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaMinDTO;
import com.jchallak.BancoAzimov.entities.TipoTransacao;

import java.time.LocalDateTime;

public class TransacaoDTO {

    private Long id;
    private Double valor;
    private LocalDateTime dataHora;
    private TipoTransacao transacao;
    private String descricao;
    private ContaBancariaMinDTO contaOrigem;
    private ContaBancariaMinDTO contaDestino;

    public TransacaoDTO() {
    }

    public TransacaoDTO(Long id, Double valor, LocalDateTime dataHora, TipoTransacao transacao, String descricao, ContaBancariaMinDTO contaOrigem, ContaBancariaMinDTO contaDestino) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
        this.transacao = transacao;
        this.descricao = descricao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
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

    public ContaBancariaMinDTO getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(ContaBancariaMinDTO contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public ContaBancariaMinDTO getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaBancariaMinDTO contaDestino) {
        this.contaDestino = contaDestino;
    }
}
