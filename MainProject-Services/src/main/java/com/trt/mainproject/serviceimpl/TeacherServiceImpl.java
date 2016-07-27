/*
 * 
 */
package com.trt.mainproject.serviceimpl;

import com.trt.mainproject.common.CommonUtilJava;
import com.trt.mainproject.dao.TeacherDao;
import com.trt.mainproject.entity.Teacher;
import com.trt.mainproject.services.TeacherService;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nilay
 */
@Service
//@TransactionConfiguration(defaultRollback = false)
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    @Transactional
    public Long create(Teacher teacher) {
        Long id = null;
        try {
            if (teacherDao != null && teacher != null) {
                String pass = teacher.getPass();
                teacher.setPass(CommonUtilJava.encryptedPassword(pass));
                id = teacherDao.create(teacher);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return id;
    }

    @Override
    @Transactional
    public Teacher retriveById(Long id) {
        Teacher teacher = new Teacher();
        try {
            if (teacherDao != null && teacher != null) {
                teacher = (Teacher) teacherDao.retriveById(id);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return teacher;
    }

    @Override
    @Transactional
    public Teacher update(Teacher teacher) {
        try {

            if (teacherDao != null && teacher != null) {
                teacher = teacherDao.update(teacher);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return teacher;
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        Boolean flag = null;
        try {
            if (teacherDao != null && id != null) {
                flag = teacherDao.delete(id);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return flag;
    }

    @Override
    @Transactional
    public List<Teacher> retriveAll() {
        List<Teacher> teachers = null;
        try {
            if (teacherDao != null) {
                teachers = teacherDao.retriveAll();
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return teachers;
    }
}
