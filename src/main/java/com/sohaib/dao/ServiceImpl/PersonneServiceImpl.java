package com.sohaib.dao.ServiceImpl;

import com.sohaib.dao.Services.PersonneService;
import com.sohaib.dao.daos.PersonneDao;
import com.sohaib.entitires.PersonneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    PersonneDao personneDao;

    @Override
    public Set<PersonneEntity> recupererToutesLesPersonnes() {
        return personneDao.recupererToutesLesPersonnes();
    }

    @Override
    public PersonneEntity trouverParId(Integer id) {
        return personneDao.trouverParId(id);
    }

    @Override
    public PersonneEntity creerPersonne(PersonneEntity personne) {
        return personneDao.creerPersonne(personne);
    }

}
