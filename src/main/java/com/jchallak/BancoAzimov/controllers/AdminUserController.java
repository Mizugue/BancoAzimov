package com.jchallak.BancoAzimov.controllers;

import com.jchallak.BancoAzimov.dtos.userDTOs.UserDTO;
import com.jchallak.BancoAzimov.services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/users")
@PreAuthorize("hasRole('ADMIN')")
public class AdminUserController {

    @Autowired
    private AdminUserService adminService;



    @GetMapping
    public ResponseEntity<List<UserDTO>> findUsers(){
        return new ResponseEntity<>(adminService.findUsers(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
        return new ResponseEntity<>(adminService.findUserById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(adminService.saveUser(userDTO), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(adminService.deleteUser(id), HttpStatus.OK);

    }
    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(adminService.updateUser(userDTO), HttpStatus.OK);
    }

}
