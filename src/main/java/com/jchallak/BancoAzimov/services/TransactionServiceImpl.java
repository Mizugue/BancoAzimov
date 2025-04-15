package com.jchallak.BancoAzimov.services;


import com.jchallak.BancoAzimov.dtos.transDTOs.TransacaoDTO;
import com.jchallak.BancoAzimov.dtos.transDTOs.TransacaoMinDTO;
import com.jchallak.BancoAzimov.entities.ContaBancaria;
import com.jchallak.BancoAzimov.entities.Transacao;
import com.jchallak.BancoAzimov.entities.User;
import com.jchallak.BancoAzimov.repositories.CBRepository;
import com.jchallak.BancoAzimov.repositories.TransacaoRepository;
import com.jchallak.BancoAzimov.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final ModelMapper modelMapper;
    private final TransacaoRepository transacaoRepository;
    private final AuthenticatedUserService authenticatedUserService;
    private final CBRepository cbRepository;

    @Autowired
    public TransactionServiceImpl (ModelMapper modelMapper, TransacaoRepository transacaoRepository, AuthenticatedUserService authenticatedUserService, CBRepository cbRepository){
        this.modelMapper = modelMapper;
        this.transacaoRepository = transacaoRepository;
        this.authenticatedUserService = authenticatedUserService;
        this.cbRepository = cbRepository;

    }


    @Override
    public List<TransacaoMinDTO> getMyTransactions() {
    User user = authenticatedUserService.authenticated();
    List<Transacao> transacoes = user.getContasBancarias().stream().flatMap(conta -> {
        List<Transacao> todas = new ArrayList<>();
        todas.addAll(conta.getTransacoesOrigem());
            todas.addAll(conta.getTransacoesDestino());
            return todas.stream();}).toList();
    return transacoes.stream().map(tx -> modelMapper.map(tx, TransacaoMinDTO.class)).toList();
}

    @Override
    public TransacaoDTO getMyTransaction(Long id) {
        User user = authenticatedUserService.authenticated();
        List<Transacao> transacoes = user.getContasBancarias().stream().flatMap(conta -> {
        List<Transacao> todas = new ArrayList<>();
        todas.addAll(conta.getTransacoesOrigem());
            todas.addAll(conta.getTransacoesDestino());
            return todas.stream();}).toList();
        for (Transacao transacao : transacoes){
            if (Objects.equals(transacao.getId(), id)) {
                return modelMapper.map(transacao, TransacaoDTO.class);
            }
        }
        throw new ResourceNotFoundException("Nao existe nenhuma transacao com o id " + id);

    }

    @Override
    @Transactional
    public TransacaoDTO newTransaction(TransacaoDTO dto, String numeroConta) {
        User user = authenticatedUserService.authenticated();
        ContaBancaria conta = cbRepository.findByNumeroConta(numeroConta).orElseThrow(() -> new ResourceNotFoundException("Conta " + numeroConta + " inexistente!"));

        if (!user.getContasBancarias().contains(conta)) {
            throw new ResourceNotFoundException("O usuario nao possui nenhuma conta de numero " + numeroConta);
        }

        Transacao transacao = new Transacao();
        transacao.setTransacao(dto.getTransacao());
        transacao.setDescricao(dto.getDescricao());
        transacao.setValor(dto.getValor());
        transacao.setDataHora(LocalDateTime.now());

        switch (dto.getTransacao()) {
            case SAQUE -> {
                if (conta.getSaldo() < dto.getValor()) {
                    throw new ResourceNotFoundException("Saldo insuficiente para saque.");
                }
                conta.setSaldo(conta.getSaldo() - dto.getValor());
                transacao.setContaOrigem(conta);
                cbRepository.save(conta);
            }
            case DEPOSITO -> {
                conta.setSaldo(conta.getSaldo() + dto.getValor());
                transacao.setContaDestino(conta);
                cbRepository.save(conta);
            }
            case TRANSFERENCIA -> {
                if (conta.getSaldo() < dto.getValor()) {
                    throw new ResourceNotFoundException("Saldo insuficiente para transferência.");
                }
                ContaBancaria destino = cbRepository.findByNumeroConta(dto.getContaDestino().getNumeroConta()).orElseThrow(() -> new ResourceNotFoundException("Conta destino não encontrada."));

                conta.setSaldo(conta.getSaldo() - dto.getValor());
                destino.setSaldo(destino.getSaldo() + dto.getValor());

                transacao.setContaOrigem(conta);
                transacao.setContaDestino(destino);

                cbRepository.save(conta);
                cbRepository.save(destino);
            }
        }

        return modelMapper.map(transacaoRepository.save(transacao), TransacaoDTO.class);
    }



    private User getAuthenticatedUser() {
        return authenticatedUserService.authenticated();
}


}
