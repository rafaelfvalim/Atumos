/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author root
 */
@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {

    private EntityManager entityManager;

    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    public T getByProperty(String property, String value) {
        try {
            T t = (T) entityManager.createQuery("SELECT T FROM " + getTypeClass().getSimpleName() + " T WHERE T." + property + " = '" + value + "'").setMaxResults(1).getSingleResult();
            return t;
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<T> findLike(String property, String value) {
        return entityManager.createQuery("SELECT T FROM " + getTypeClass().getSimpleName() + " T WHERE T." + property + " LIKE '%" + value + "%'").getResultList();
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public List<T> findAll() {
        return entityManager.createQuery(("SELECT T FROM " + getTypeClass().getSimpleName() + " T "))
                .getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
