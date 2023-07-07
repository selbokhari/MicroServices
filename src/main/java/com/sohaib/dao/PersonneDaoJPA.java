package com.sohaib.dao;

import com.sohaib.entitires.PersonneEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
*
* Spring Data
* */

@Repository
public interface PersonneDaoJPA extends CrudRepository<PersonneEntity, Long> {

}
