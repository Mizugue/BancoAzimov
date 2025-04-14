package com.jchallak.BancoAzimov.controllers;

import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaDTO;
import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaFullDTO;
import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaMinDTO;
import com.jchallak.BancoAzimov.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/me")
public class AccountController {


    @Autowired
    private AccountService accountService;


    @GetMapping(value = "/account")
    public ResponseEntity<List<ContaBancariaMinDTO>> getMyAccounts(){
        return new ResponseEntity<>(accountService.getMyAccounts(), HttpStatus.OK);
    }

    @GetMapping(value = "/account/{n}")
    public ResponseEntity<ContaBancariaFullDTO> getMyAccount(@PathVariable String n){
        return new ResponseEntity<>(accountService.getMyAccount(n), HttpStatus.OK);
    }



}
