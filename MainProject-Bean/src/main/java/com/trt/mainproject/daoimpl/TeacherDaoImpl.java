/*
 * implementation of above override method or Aditional method.
 */
package com.trt.mainproject.daoimpl;

import com.trt.mainproject.dao.TeacherDao;
import com.trt.mainproject.entity.Teacher;
import com.trt.mainproject.genricdaoimpl.GenericDaoImpl;

/**
 *
 * @author nilay
 */
public class TeacherDaoImpl extends GenericDaoImpl<Teacher> implements TeacherDao {

    public TeacherDaoImpl() {
        super(Teacher.class);
    }

}
