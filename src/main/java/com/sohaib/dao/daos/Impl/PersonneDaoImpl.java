package com.sohaib.dao.daos.Impl;

import com.sohaib.dao.PersonneDaoJPA;
import com.sohaib.dao.abstractDao.AbstractDaoImpl;
import com.sohaib.dao.daos.PersonneDao;
import com.sohaib.entitires.PersonneEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import java.util.Set;

@Repository
public class PersonneDaoImpl extends AbstractDaoImpl<PersonneEntity,Integer> implements PersonneDao {

    @Autowired
    @Qualifier("personneDaoJPA")
    PersonneDaoJPA personneDaoJPA;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CrudRepository getCrudRepositoryImpl() {
        return this.personneDaoJPA;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Set<PersonneEntity> recupererToutesLesPersonnes() {
        return findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public PersonneEntity trouverParId(Integer id) {
        return findById(id).orElse(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public PersonneEntity creerPersonne(PersonneEntity personne) {
        return  create(personne);
    }
}
