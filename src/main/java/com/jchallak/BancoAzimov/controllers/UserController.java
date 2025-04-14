package com.jchallak.BancoAzimov.controllers;


import com.jchallak.BancoAzimov.dtos.userDTOs.PasswordChangeDTO;
import com.jchallak.BancoAzimov.dtos.userDTOs.UserDTO;
import com.jchallak.BancoAzimov.dtos.userDTOs.UserRegisterDTO;
import com.jchallak.BancoAzimov.dtos.userDTOs.UserReturnOfRegisterDTO;
import com.jchallak.BancoAzimov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserReturnOfRegisterDTO> saveUser(@RequestBody UserRegisterDTO userDTO){
        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> getMe(){
        return new ResponseEntity<>(userService.getMe(), HttpStatus.OK);
    }

    @PostMapping(value = "/new-password")
    public ResponseEntity<String> newPassword(@RequestBody PasswordChangeDTO dto){
        return new ResponseEntity<>(userService.newPassword(dto.getNewPassword(), dto.getOldPassword()), HttpStatus.OK);
    }


}
