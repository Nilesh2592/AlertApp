/*
 * 
 */
package com.trt.mainproject.services;


import com.trt.mainproject.entity.Teacher;
import java.util.List;

/**
 *
 * @author nilay
 */
public interface TeacherService {

    public Long create(Teacher teacher);
    public Teacher retriveById(Long id) ;
    public Teacher update(Teacher teacher);
    public Boolean delete(Long id);
    public List<Teacher> retriveAll();
}
