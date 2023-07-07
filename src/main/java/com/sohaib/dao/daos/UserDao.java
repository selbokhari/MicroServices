package com.sohaib.dao.daos;

import com.sohaib.entitires.UserEntity;

import java.util.Optional;

public interface UserDao {

    Optional<UserEntity> recupererUtilisateurParLogin(String login);

    UserEntity createUser(UserEntity user);

}
