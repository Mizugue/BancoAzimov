package com.jchallak.BancoAzimov.services;

import com.jchallak.BancoAzimov.dtos.ContaBancariaDTO;
import com.jchallak.BancoAzimov.dtos.TransacaoDTO;
import com.jchallak.BancoAzimov.dtos.UserDTO;
import com.jchallak.BancoAzimov.entities.ContaBancaria;
import com.jchallak.BancoAzimov.entities.Role;
import com.jchallak.BancoAzimov.entities.User;
import com.jchallak.BancoAzimov.repositories.CBRepository;
import com.jchallak.BancoAzimov.repositories.RoleRepository;
import com.jchallak.BancoAzimov.repositories.TransacaoRepository;
import com.jchallak.BancoAzimov.repositories.UserRepository;
import com.jchallak.BancoAzimov.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CBRepository cbRepository;
    private final TransacaoRepository transacaoRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository, ModelMapper modelMapper, CBRepository cbRepository, TransacaoRepository transacaoRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.cbRepository = cbRepository;
        this.transacaoRepository = transacaoRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public List<UserDTO> findUsers() {
        return userRepository.findAll().stream().map(x -> UserDTO.fromEntity(x, modelMapper)).toList();
    }
    @Override
    public UserDTO findUserById(Long id) {
        return userRepository.findById(id).map(x -> modelMapper.map(x, UserDTO.class)).orElseThrow(() -> new ResourceNotFoundException("User com Id " + id + " inexistente"));
    }
    @Override
    public UserDTO saveUser(UserDTO userDTO){
        User user = userRepository.save(modelMapper.map(userDTO, User.class));
        return modelMapper.map(user, UserDTO.class);
    }
    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("User com Id " + userDTO.getId() + " inexistente"));
        user.setUsername(userDTO.getUsername());
        user.setCriadoEm(userDTO.getCriadoEm());
        user.setAtivo(userDTO.getAtivo());
        user.setEmail(userDTO.getEmail());
        user.setRoles(userDTO.getRoles());
        user.setSenha(userDTO.getSenha());
        userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User com Id " + id + " inexistente"));
        userRepository.deleteById(id);
        return "User " + user.getUsername() + " deletado com sucesso! ";
    }


    @Override
    public List<ContaBancariaDTO> findAccounts() {
        return cbRepository.findAll().stream().map(x -> modelMapper.map(x, ContaBancariaDTO.class)).toList();
    }
    @Override
    public ContaBancariaDTO findAccountById(Long id) {
        return cbRepository.findById(id).map(x -> modelMapper.map(x, ContaBancariaDTO.class)).orElseThrow(() -> new ResourceNotFoundException("Conta com Id " + id + " inexistente"));
    }
    @Override
    public ContaBancariaDTO saveAccount(ContaBancariaDTO contaBancariaDTO) {
        return null;
    }
    @Override
    public ContaBancariaDTO updateAccount(ContaBancariaDTO contaBancariaDTO) {
        return null;
    }
    @Override
    public String deleteAccount(Long id) {
        return "";
    }


    @Override
    public List<TransacaoDTO> findTransactions() {
        return transacaoRepository.findAll().stream().map(x -> modelMapper.map(x, TransacaoDTO.class)).toList();
    }
    @Override
    public TransacaoDTO findTransactionById(Long id) {
        return transacaoRepository.findById(id).map(x -> modelMapper.map(x, TransacaoDTO.class)).orElseThrow(() -> new ResourceNotFoundException("Transacao com Id " + id + " inexistente"));
    }
    @Override
    public TransacaoDTO saveTransaction(TransacaoDTO transacaoDTO) {
        return null;
    }
    @Override
    public TransacaoDTO updateTransaction(TransacaoDTO transacaoDTO) {
        return null;
    }
    @Override
    public TransacaoDTO deleteTransaction(Long id) {
        return null;
    }


}
