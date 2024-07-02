package com.maen.service.implementation;

import com.maen.presentation.dto.UserDTO;
import com.maen.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }
}
