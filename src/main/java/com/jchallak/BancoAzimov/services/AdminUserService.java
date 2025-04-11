package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.UserDTO;

import java.util.List;

public interface AdminUserService {
    List<UserDTO> findUsers();
    UserDTO findUserById(Long id);
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    String deleteUser(Long id);

}
