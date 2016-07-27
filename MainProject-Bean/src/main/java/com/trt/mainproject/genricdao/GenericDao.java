/*
 * This is Generic Dao class. 
 * this interface define common method of the dao class
 */
package com.trt.mainproject.genricdao;

import java.util.HashMap;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author nilay
 */
public interface GenericDao<T> {

    public Long create(T entity) throws HibernateException;

    public T retriveById(Long id) throws HibernateException;

    public T update(T entity) throws HibernateException;

    public Boolean delete(Long id) throws HibernateException;

    public List<T> retriveAll();

    public List<T> retriveByCriteria(HashMap<String, Object> hashMap);
}
