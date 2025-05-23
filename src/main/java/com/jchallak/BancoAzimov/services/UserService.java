package com.jchallak.BancoAzimov.services;


import com.jchallak.BancoAzimov.dtos.userDTOs.PasswordChangeDTO;
import com.jchallak.BancoAzimov.dtos.userDTOs.UserDTO;
import com.jchallak.BancoAzimov.dtos.userDTOs.UserRegisterDTO;
import com.jchallak.BancoAzimov.dtos.userDTOs.UserReturnOfRegisterDTO;

public interface UserService {
    UserReturnOfRegisterDTO saveUser(UserRegisterDTO userDTO);
    UserDTO getMe();
    String newPassword(String newPassword, String oldPassword);
}
