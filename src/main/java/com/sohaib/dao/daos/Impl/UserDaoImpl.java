package com.sohaib.dao.daos.Impl;

import com.sohaib.dao.UserDaoJPA;
import com.sohaib.dao.abstractDao.AbstractDaoImpl;
import com.sohaib.dao.daos.UserDao;
import com.sohaib.entitires.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<UserEntity, Integer> implements UserDao {

    @Autowired
    UserDaoJPA userRepository;

    @Override
    public Optional<UserEntity> recupererUtilisateurParLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public CrudRepository<UserEntity, Integer> getCrudRepositoryImpl() {
        return userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

}
