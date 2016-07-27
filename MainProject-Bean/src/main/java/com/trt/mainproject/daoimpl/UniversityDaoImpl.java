/*
 * implementation of above override method or Aditional method.
 */
package com.trt.mainproject.daoimpl;

import com.trt.mainproject.dao.UniversityDao;
import com.trt.mainproject.entity.University;
import com.trt.mainproject.genricdaoimpl.GenericDaoImpl;

/**
 *
 * @author nilay
 */
public class UniversityDaoImpl extends GenericDaoImpl<University> implements UniversityDao {

    public UniversityDaoImpl() {
        super(University.class);
    }

}
