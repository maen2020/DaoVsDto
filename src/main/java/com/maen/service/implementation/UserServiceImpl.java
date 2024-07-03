package com.maen.service.implementation;

import com.maen.persistence.dao.interfaces.IUserDAO;
import com.maen.persistence.entity.UserEntity;
import com.maen.presentation.dto.UserDTO;
import com.maen.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    // Inyectar interfaz IUserDAO
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<UserDTO> findAll() {

        // Se encarga de convertir un IUserDTO a IUserEntity.
        // Y un IUserEntity a IUserDTO.
        ModelMapper modelMapper = new ModelMapper();

        // Retorna una lista de UserEntity de la base de datos y la convierte a una lista de UserDTO.
        return this.userDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<UserEntity> userEntity = this.userDAO.findById(id);
        if (userEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            UserEntity currentUser = userEntity.get();
            return modelMapper.map(currentUser, UserDTO.class);
        } else {
            return new UserDTO();
        }
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        try {
            ModelMapper modelMapper = new ModelMapper();
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            this.userDAO.saveUser(userEntity);
            return userDTO;
        } catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el usuario");
        }
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        Optional<UserEntity> userEntity = this.userDAO.findById(id);
        if (userEntity.isPresent()){
           UserEntity currentUserEntity = userEntity.get();
           currentUserEntity.setName(userDTO.getName());
           currentUserEntity.setLastName(userDTO.getLastName());
           currentUserEntity.setEmail(userDTO.getEmail());
           currentUserEntity.setAge(userDTO.getAge());

           this.userDAO.updateUser(currentUserEntity);

           ModelMapper modelMapper = new ModelMapper();
           return  modelMapper.map(currentUserEntity, UserDTO.class);
        } else {
            throw new IllegalArgumentException("El usuario no existe.");
        }
    }

    @Override
    public String deleteUser(Long id) {
        Optional<UserEntity> userEntity = this.userDAO.findById(id);

        if (userEntity.isPresent()){
            UserEntity currentUserEntity = userEntity.get();
            this.userDAO.deleteUser(currentUserEntity);
            return "Usuario con ID " + id + " ha sido eliminado.";
        } else {
            return "El usuario con ID " + id + " no existe.";
        }
    }
}
