package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaDTO;
import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaFullDTO;
import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaMinDTO;


import java.util.List;

public interface AccountService {
    List<ContaBancariaMinDTO> getMyAccounts();
    ContaBancariaFullDTO getMyAccount(String n);
}
