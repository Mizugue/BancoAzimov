package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaDTO;
import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaFullDTO;
import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaMinDTO;
import com.jchallak.BancoAzimov.entities.ContaBancaria;
import com.jchallak.BancoAzimov.entities.User;
import com.jchallak.BancoAzimov.repositories.CBRepository;
import com.jchallak.BancoAzimov.repositories.UserRepository;
import com.jchallak.BancoAzimov.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private final AuthenticatedUserService authenticatedUserService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CBRepository cbRepository;

    @Autowired
    public AccountServiceImpl (CBRepository cbRepository, AuthenticatedUserService authenticatedUserService, UserRepository userRepository, ModelMapper modelMapper){
        this.authenticatedUserService = authenticatedUserService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.cbRepository = cbRepository;
    }


    @Override
    public List<ContaBancariaMinDTO> getMyAccounts() {
        User user = authenticatedUserService.authenticated();
        return user.getContasBancarias().stream().map(conta -> modelMapper.map(conta, ContaBancariaMinDTO.class)).toList();

    }

    @Override
    public ContaBancariaFullDTO getMyAccount(String n) {
        User user = authenticatedUserService.authenticated();
        for (ContaBancaria contaBancaria : user.getContasBancarias()){
            if (contaBancaria.getNumeroConta().equals(n)){
                return modelMapper.map(contaBancaria, ContaBancariaFullDTO.class);
            }
        }
        throw new ResourceNotFoundException("Nao foi encontrada nenhuma conta bancaria de numero " + n);

    }
}
