package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.TransacaoMinDTO;

import java.util.List;

public interface TransactionService {
    List<TransacaoMinDTO> getMyTransactions();
}
