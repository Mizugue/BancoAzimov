package com.jchallak.BancoAzimov.dtos.transDTOs;



import com.jchallak.BancoAzimov.entities.TipoTransacao;
import com.jchallak.BancoAzimov.entities.Transacao;

import java.time.LocalDateTime;

public class TransacaoMinDTO {

    private Long id;
    private Double valor;
    private LocalDateTime dataHora;
    private TipoTransacao transacao;
    private String descricao;

    public TransacaoMinDTO() {
    }

    public TransacaoMinDTO(Transacao transacao){
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.dataHora = transacao.getDataHora();
        this.transacao = transacao.getTransacao();
        this.descricao = transacao.getDescricao();
    }

    public TransacaoMinDTO(Long id, Double valor, LocalDateTime dataHora, TipoTransacao transacao, String descricao) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
        this.transacao = transacao;
        this.descricao = descricao;
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


}
