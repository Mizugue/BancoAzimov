package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.TransacaoMinDTO;
import com.jchallak.BancoAzimov.entities.ContaBancaria;
import com.jchallak.BancoAzimov.entities.Transacao;
import com.jchallak.BancoAzimov.entities.User;
import com.jchallak.BancoAzimov.repositories.TransacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final ModelMapper modelMapper;
    private final TransacaoRepository transacaoRepository;
    private final AuthenticatedUserService authenticatedUserService;

    @Autowired
    public TransactionServiceImpl (ModelMapper modelMapper, TransacaoRepository transacaoRepository, AuthenticatedUserService authenticatedUserService){
        this.modelMapper = modelMapper;
        this.transacaoRepository = transacaoRepository;
        this.authenticatedUserService = authenticatedUserService;

    }


    @Override
    public List<TransacaoMinDTO> getMyTransactions() {
    User user = authenticatedUserService.authenticated();
    List<Transacao> transacoes = user.getContasBancarias().stream()
        .flatMap(conta -> {
            List<Transacao> todas = new ArrayList<>();
            todas.addAll(conta.getTransacoesOrigem());
            todas.addAll(conta.getTransacoesDestino());
            return todas.stream();}).toList();
    return transacoes.stream().map(tx -> modelMapper.map(tx, TransacaoMinDTO.class)).toList();
}


    private User getAuthenticatedUser() {
        return authenticatedUserService.authenticated();
}


}
