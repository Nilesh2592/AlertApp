/*
 * 
 */
package com.trt.myproject.daoimpl;

import com.trt.mainproject.common.CommonUtilJava;
import com.trt.mainproject.dao.TeacherDao;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.Teacher;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nilay
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfigBean.class})
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TeacherDaoImplTest {

    @Autowired
    private TeacherDao teacherDao;

//    @Test
//    @Transactional
    public void testCreate() {
        Teacher entity = new Teacher();
        Long id;
        entity.setName("Dhaval");
        entity.setUname("dhaval");
        String pass = "dhaval";
        String encPassStr = CommonUtilJava.encryptedPassword(pass);
        entity.setPass(encPassStr);
        entity.setMobile("7600422543");
        id = teacherDao.create(entity);
        assertNotNull(entity.getId());
    }

//    @Test
//    @Transactional
    public void testRetriveById() {
        System.out.println("Search By Id Mentod");
        Teacher entity = new Teacher();
        Long id = 6l;
        entity = (Teacher) teacherDao.retriveById(id);
        System.out.println("Record Found: " + entity);
        assertNotNull(entity);
    }

//    @Test
//    @Transactional
    public void testUpdate() {
        System.out.println("Update Method");
        Teacher entity = new Teacher();

        entity = teacherDao.retriveById(6l);
        System.out.println("Searched Entity : " + entity);
        entity.setName("update");
        entity.setUname("update");
        entity.setPass("123456");
        entity.setMobile("987654321");
        entity = teacherDao.update(entity);

        assertNotNull(entity);
    }

//    @Test
//    @Transactional
    public void testDelete() {
        System.out.println("Delete Method");
        Long id = 6l;
        Boolean flag = false;
        flag = teacherDao.delete(id);
        System.out.println("Record Deleted : " + flag);

        assertEquals(flag, true);
    }

//    @Test
    public void testRetriveAll() {
        List<Teacher> teachers;
        teachers = teacherDao.retriveAll();
        assertNotNull(teachers);
    }

//    @Test
    public void testAll() {

        Teacher entity = new Teacher();

        // For Create Method
        Long id;
        entity.setName("Mitul");
        entity.setUname("mitul");
        String pass = "mit";
        String encPassStr = CommonUtilJava.encryptedPassword(pass);
        entity.setPass(encPassStr);
        entity.setMobile("9737973737");
        id = teacherDao.create(entity);
        assertNotNull(entity.getId());

        // For RetriveById Method
        entity = (Teacher) teacherDao.retriveById(id);
        System.out.println("Record Found: " + entity);
        assertNotNull(entity);

        // For Update Method
        entity = teacherDao.retriveById(id);
        entity.setName("update");
        entity.setUname("update");
        String pass2 = "update";
        String encPassStr2 = CommonUtilJava.encryptedPassword(pass2);
        entity.setPass(encPassStr2);
        entity.setMobile("987654321");
        entity = teacherDao.update(entity);
        assertNotNull(entity);

        //For Delete Method
        Boolean flag = false;
        flag = teacherDao.delete(id);
        System.out.println("Record Deleted : " + flag);
        assertEquals(flag, true);

        // For Retrive all
        List<Teacher> teachers;
        teachers = teacherDao.retriveAll();
        assertNotNull(teachers);
    }
}
