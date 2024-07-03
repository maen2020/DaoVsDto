package com.maen.persistence.dao.interfaces;

import com.maen.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

// El DAO solo recibe objetos Entity.
// Dentro del DAO no es necesario mandar los id (update and delete).
public interface IUserDAO {

    // Metodos que van a interactuar con la base de datos.
    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);
    void saveUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    void deleteUser(UserEntity userEntity);
}
