package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.ContaBancariaDTO;
import com.jchallak.BancoAzimov.dtos.TransacaoDTO;
import com.jchallak.BancoAzimov.dtos.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findUsers();
    UserDTO findUserById(Long id);
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    String deleteUser(Long id);

    List<ContaBancariaDTO> findAccounts();
    ContaBancariaDTO findAccountById(Long id);
    ContaBancariaDTO saveAccount(ContaBancariaDTO contaBancariaDTO);
    ContaBancariaDTO updateAccount(ContaBancariaDTO contaBancariaDTO);
    String deleteAccount(Long id);


    List<TransacaoDTO> findTransactions();
    TransacaoDTO findTransactionById(Long id);
    TransacaoDTO saveTransaction(TransacaoDTO transacaoDTO);
    TransacaoDTO updateTransaction(TransacaoDTO transacaoDTO);
    TransacaoDTO deleteTransaction(Long id);

}
