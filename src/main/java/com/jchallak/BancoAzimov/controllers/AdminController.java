package com.jchallak.BancoAzimov.controllers;

import com.jchallak.BancoAzimov.dtos.ContaBancariaDTO;
import com.jchallak.BancoAzimov.dtos.TransacaoDTO;
import com.jchallak.BancoAzimov.dtos.UserDTO;
import com.jchallak.BancoAzimov.entities.User;
import com.jchallak.BancoAzimov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDTO>> findUsers(){
        return new ResponseEntity<>(userService.findUsers(), HttpStatus.OK);
    }
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/users")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);

    }
    @PutMapping(value = "/users")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.updateUser(userDTO), HttpStatus.OK);
    }


    @GetMapping(value = "/accounts")
    public ResponseEntity<List<ContaBancariaDTO>> findAccounts(){
        return new ResponseEntity<>(userService.findAccounts(), HttpStatus.OK);
    }
    @GetMapping(value = "/accounts/{id}")
    public ResponseEntity<ContaBancariaDTO> findAccountById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findAccountById(id), HttpStatus.OK);
    }



    @GetMapping(value = "/transactions")
    public ResponseEntity<List<TransacaoDTO>> findTransactions(){
        return new ResponseEntity<>(userService.findTransactions(), HttpStatus.OK);
    }
    @GetMapping(value = "/transactions/{id}")
    public ResponseEntity<TransacaoDTO> findTransactionsById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findTransactionById(id), HttpStatus.OK);
    }




}
