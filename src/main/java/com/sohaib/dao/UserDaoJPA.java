package com.sohaib.dao;

import com.sohaib.entitires.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data
 **/

@Repository
public interface UserDaoJPA extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findByLogin(@Param("login") String login);

}
