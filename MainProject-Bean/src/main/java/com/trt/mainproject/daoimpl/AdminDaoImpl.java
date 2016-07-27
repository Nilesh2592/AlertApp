/*
 * implementation of above override method or Aditional method.
 */
package com.trt.mainproject.daoimpl;

import com.trt.mainproject.dao.AdminDao;
import com.trt.mainproject.entity.Admin;
import com.trt.mainproject.genricdaoimpl.GenericDaoImpl;

/**
 *
 * @author nilay
 */
public class AdminDaoImpl extends GenericDaoImpl<Admin> implements AdminDao {

    public AdminDaoImpl() {
        super(Admin.class);
    }
}
