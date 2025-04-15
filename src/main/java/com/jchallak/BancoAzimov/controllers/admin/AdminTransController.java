package com.jchallak.BancoAzimov.controllers.admin;

import com.jchallak.BancoAzimov.dtos.transDTOs.TransacaoDTO;
import com.jchallak.BancoAzimov.services.admin.AdminTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/transactions")
@PreAuthorize("hasRole('ADMIN')")
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
