package com.jchallak.BancoAzimov.controllers;

import com.jchallak.BancoAzimov.dtos.TransacaoDTO;
import com.jchallak.BancoAzimov.services.AdminTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/transactions")
public class AdminTransController {


    @Autowired
    private AdminTransService adminService;

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> findTransactions(){
        return new ResponseEntity<>(adminService.findTransactions(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TransacaoDTO> findTransactionsById(@PathVariable Long id){
        return new ResponseEntity<>(adminService.findTransactionById(id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTransactions(@PathVariable Long id){
        return new ResponseEntity<>(adminService.deleteTransaction(id), HttpStatus.OK);
    }




}
