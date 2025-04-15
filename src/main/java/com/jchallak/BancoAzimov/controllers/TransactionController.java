package com.jchallak.BancoAzimov.controllers;

import com.jchallak.BancoAzimov.dtos.TransacaoMinDTO;
import com.jchallak.BancoAzimov.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/me/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;



    @GetMapping
    public ResponseEntity<List<TransacaoMinDTO>> getMyAccounts(){
        return new ResponseEntity<>(transactionService.getMyTransactions(), HttpStatus.OK);

    }


}
