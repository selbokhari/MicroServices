package com.sohaib.dao.daos;

import com.sohaib.entitires.PersonneEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PersonneDao {

    Set<PersonneEntity> recupererToutesLesPersonnes();

    PersonneEntity trouverParId(Integer id);

    PersonneEntity creerPersonne(PersonneEntity personne);

}
