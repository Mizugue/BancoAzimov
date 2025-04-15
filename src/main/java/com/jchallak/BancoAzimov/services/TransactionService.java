package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.transDTOs.TransacaoDTO;
import com.jchallak.BancoAzimov.dtos.transDTOs.TransacaoMinDTO;

import java.util.List;

public interface TransactionService {
    List<TransacaoMinDTO> getMyTransactions();
    TransacaoDTO getMyTransaction(Long id);
    TransacaoDTO newTransaction(TransacaoDTO transacaoDTO, String numberAccount);
}
