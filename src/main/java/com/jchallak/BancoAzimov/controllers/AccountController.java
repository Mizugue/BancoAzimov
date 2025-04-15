package com.jchallak.BancoAzimov.controllers;

import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaFullDTO;
import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaMinDTO;
import com.jchallak.BancoAzimov.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/me/account")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<ContaBancariaMinDTO>> getMyAccounts(){
        return new ResponseEntity<>(accountService.getMyAccounts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{n}")
    public ResponseEntity<ContaBancariaFullDTO> getMyAccount(@PathVariable String n){
        return new ResponseEntity<>(accountService.getMyAccount(n), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> newAccount(@RequestBody ContaBancariaMinDTO dto){
        return new ResponseEntity<>(accountService.newAccount(dto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{n}")
    public ResponseEntity<String> deleteAccount(@PathVariable String n){
        return new ResponseEntity<>(accountService.deleteAccount(n), HttpStatus.OK);
    }





}
