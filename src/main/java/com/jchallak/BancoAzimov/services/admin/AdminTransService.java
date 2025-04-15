package com.jchallak.BancoAzimov.services.admin;

import com.jchallak.BancoAzimov.dtos.transDTOs.TransacaoDTO;

import java.util.List;

public interface AdminTransService {
    List<TransacaoDTO> findTransactions();
    TransacaoDTO findTransactionById(Long id);
    String deleteTransaction(Long id);

}
