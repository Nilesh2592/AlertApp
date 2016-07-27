/*
 * This is interface is uae for check login username and password into database.
 */
package com.trt.mainproject.authenticatedao;

import com.trt.mainproject.entity.Teacher;
import org.hibernate.HibernateException;

/**
 *
 * @author nilay
 */
public interface AuthenticateDao {

    public Teacher checkLogin(String uname, String pass, Boolean isActice) throws HibernateException;
}
