package com.jchallak.BancoAzimov.controllers;

import com.jchallak.BancoAzimov.dtos.transDTOs.TransacaoDTO;
import com.jchallak.BancoAzimov.dtos.transDTOs.TransacaoMinDTO;
import com.jchallak.BancoAzimov.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransacaoDTO> getMyTransaction(@PathVariable Long id){
        return new ResponseEntity<>(transactionService.getMyTransaction(id), HttpStatus.OK);
    }

    @PostMapping(value = "/{n}")
    public ResponseEntity<TransacaoDTO> newTransaction(@RequestBody TransacaoDTO transacaoDTO, @PathVariable String n){
        return new ResponseEntity<>(transactionService.newTransaction(transacaoDTO, n), HttpStatus.CREATED);
    }




}
