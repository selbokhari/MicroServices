package com.sohaib.dao.abstractDao;

import com.sohaib.entitires.AbstractEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


/*
 * @Transactional : nécessaire pour l'interaction avec la BDD, et ça nécessite une transaction manager voir data la classe => DataSourceConf
 */

/**
 * @param <T> : La classe entité
 * @param <D> : La classe de la clé primaire
 */

@Repository
public abstract class AbstractDaoImpl<T extends AbstractEntity, D> implements AbstractDao<T> {

    /**
     * @Qualifier: est nécessaire dans le cas de plusieurs dataSources
     */
    @Autowired
    @Qualifier(value = "entityManagerFactory")
    EntityManager entityManager;

    /**
     * à implémenter par les sous DAOs selon leurs classes
     *
     * DP Factory Méthode
     *
     */
    public abstract CrudRepository<T, D> getCrudRepositoryImpl();

    @Override
    public <S extends T> S create(S entity) {
        entity.setDateModification(new Date());
        return getCrudRepositoryImpl().save(entity);
    }

    @Override
    public void delete(T entity) {
        getCrudRepositoryImpl().delete(entity);
    }

    @Override
    public <S extends T> S update(S entity) {
        entity.setDateModification(new Date());
        return entityManager.merge(entity);
    }

    @Override
    public Set<T> findAll() {
        Set<T> target = new HashSet<>();
        getCrudRepositoryImpl().findAll().forEach(target::add);
        return target;
    }

    @Override
    public Optional<T> findById(Integer id) {

        return getCrudRepositoryImpl().findById((D) id);
    }

    @Override
    public void detach(T entity) {
        entityManager.detach(entity);
    }

}
