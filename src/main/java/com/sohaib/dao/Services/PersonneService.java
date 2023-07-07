package com.sohaib.dao.Services;


import com.sohaib.entitires.PersonneEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PersonneService {

    Set<PersonneEntity> recupererToutesLesPersonnes();

    PersonneEntity trouverParId(Integer id);

    PersonneEntity creerPersonne(PersonneEntity personne);

}
