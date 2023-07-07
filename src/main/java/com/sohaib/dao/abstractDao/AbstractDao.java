package com.sohaib.dao.abstractDao;

import java.util.Optional;
import java.util.Set;

public interface AbstractDao<T> {

    <S extends T> S create(S entity);

    <S extends T> S update(S entity);

    void delete(T entity);

    Set<T> findAll();

    Optional<T> findById(Integer id);

    void detach(T entity);

}
