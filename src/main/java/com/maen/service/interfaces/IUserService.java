package com.maen.service.interfaces;

import com.maen.presentation.dto.UserDTO;

import java.util.List;

// Se definen los metodos que se van a manejar en el servicio.
public interface IUserService {
    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    String deleteUser(Long id);
}
