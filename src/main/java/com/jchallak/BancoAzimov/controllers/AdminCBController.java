package com.jchallak.BancoAzimov.controllers;

import com.jchallak.BancoAzimov.dtos.CBDTOs.ContaBancariaDTO;
import com.jchallak.BancoAzimov.services.AdminCBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/accounts")
@PreAuthorize("hasRole('ADMIN')")
public class AdminCBController {

    @Autowired
    private AdminCBService adminService;


    @GetMapping
    public ResponseEntity<List<ContaBancariaDTO>> findAccounts(){
        return new ResponseEntity<>(adminService.findAccounts(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaBancariaDTO> findAccountById(@PathVariable Long id){
        return new ResponseEntity<>(adminService.findAccountById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ContaBancariaDTO> saveAccount(@RequestBody ContaBancariaDTO contaBancariaDTO){
        return new ResponseEntity<>(adminService.saveAccount(contaBancariaDTO), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        return new ResponseEntity<>(adminService.deleteAccount(id), HttpStatus.OK);
    }

}
