package com.maen.persistence.dao.implementation;

import com.maen.persistence.dao.interfaces.IUserDAO;
import com.maen.persistence.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Implemetar los metodos de la interfaz del IUserDAO.
@Repository // indicar que es un repositorio y va a interactuar con la base de datos.
public class UserDaoImpl implements IUserDAO {

    // Cargar el administrador de persistencia de JPA.
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true) //Se le coloca para decir que solo va hacer de lectura.
    public List<UserEntity> findAll() {
        return this.em.createQuery("SELECT u FROM UserEntity u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(UserEntity.class, id));
    }

    @Override
    @Transactional
    public void saveUser(UserEntity userEntity) {
        this.em.persist(userEntity);
        this.em.flush(); //Asegura que todo se sincronice con la base de datos.
    }

    @Override
    @Transactional
    public void updateUser(UserEntity userEntity) {
        this.em.merge(userEntity);
    }

    @Override
    @Transactional
    public void deleteUser(UserEntity userEntity) {
        this.em.remove(userEntity);
    }
}