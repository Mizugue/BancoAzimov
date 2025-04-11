package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.TransacaoDTO;

import java.util.List;

public interface AdminTransService {
    List<TransacaoDTO> findTransactions();
    TransacaoDTO findTransactionById(Long id);
    String deleteTransaction(Long id);

}
