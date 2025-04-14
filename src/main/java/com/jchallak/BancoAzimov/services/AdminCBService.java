package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaDTO;

import java.util.List;

public interface AdminCBService {
    List<ContaBancariaDTO> findAccounts();
    ContaBancariaDTO findAccountById(Long id);
    ContaBancariaDTO saveAccount(ContaBancariaDTO contaBancariaDTO);
    String deleteAccount(Long id);


}
