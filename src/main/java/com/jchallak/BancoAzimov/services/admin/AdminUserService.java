package com.jchallak.BancoAzimov.services.admin;

import com.jchallak.BancoAzimov.dtos.userDTOs.UserDTO;

import java.util.List;

public interface AdminUserService {
    List<UserDTO> findUsers();
    UserDTO findUserById(Long id);
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    String deleteUser(Long id);

}
