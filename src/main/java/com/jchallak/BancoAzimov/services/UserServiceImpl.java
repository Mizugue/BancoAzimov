package com.jchallak.BancoAzimov.services;


import com.jchallak.BancoAzimov.dtos.userDTOs.UserDTO;
import com.jchallak.BancoAzimov.dtos.userDTOs.UserRegisterDTO;
import com.jchallak.BancoAzimov.dtos.userDTOs.UserReturnOfRegisterDTO;
import com.jchallak.BancoAzimov.entities.Role;
import com.jchallak.BancoAzimov.entities.User;
import com.jchallak.BancoAzimov.repositories.RoleRepository;
import com.jchallak.BancoAzimov.repositories.UserRepository;
import com.jchallak.BancoAzimov.services.exceptions.ResourceNotFoundException;
import com.jchallak.BancoAzimov.services.security.UserDetailsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;




@Service
public class UserServiceImpl implements UserDetailsService, UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticatedUserService authenticatedUserService;




    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository, AuthenticatedUserService authenticatedUserService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.authenticatedUserService = authenticatedUserService;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User  " + username + " nao foi encontrado!"));
        return UserDetailsImpl.build(user);
        }

@Override
public UserReturnOfRegisterDTO saveUser(UserRegisterDTO userDTO) {

    User user = modelMapper.map(userDTO, User.class);
    user.setAtivo(true);
    user.setCriadoEm(LocalDateTime.now());
    user.setSenha(passwordEncoder.encode(userDTO.getSenha()));
    String roleAuthority = user.getUsername().startsWith("admin") ? "ROLE_ADMIN" : "ROLE_USER";
    Optional<Role> role = roleRepository.findByAuthority(roleAuthority);

    if (role.isEmpty()) {
        throw new RuntimeException("Role não encontrada: " + roleAuthority);
    }
    user.addRole(role.get());
    return modelMapper.map(userRepository.save(user), UserReturnOfRegisterDTO.class);
}

    @Override
    public UserDTO getMe() {
        User user = authenticatedUserService.authenticated();
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public String newPassword(String newPassword, String oldPassword) {
        User user = authenticatedUserService.authenticated();
        if ((!passwordEncoder.matches(oldPassword, user.getSenha()))){
            return "Senha antiga incorreta!";

        }
        user.setSenha(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return "Nova senha salva com sucesso!";
    }





}
