/*
 *
 */
package com.trt.myproject.daoimpl;

import com.trt.mainproject.dao.UniversityDao;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.University;
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
public class UniversityDaoImplTest {

    @Autowired
    private UniversityDao universityDao;

//    @Test
//    @Transactional
    public void testCreate() {
        System.out.println("Create Method");
        University entity = new University();
        Long id;
        entity.setName("Ganapat");
        entity.setRegno("12345");
        id = universityDao.create(entity);

        assertNotNull(id);
    }

//    @Test
//    @Transactional
    public void testRetriveById() {
        System.out.println("Retrive Method : ");
        University entity = new University();
        Long id = 3l;
        entity = (University) universityDao.retriveById(id);
        System.out.println("Record Found: " + entity);

        assertNotNull(entity);
    }

//    @Test
//    @Transactional
    public void testUpdate() {
        System.out.println("Update Method");
        University entity = new University();
        Long id = 3l;
        entity = (University) universityDao.retriveById(id);
        entity.setName("HNGU");
        entity.setRegno("00000");
        entity = universityDao.update(entity);
        System.out.println("Updated Entity : " + entity);
        assertNotNull(entity);
    }

//    @Test
//    @Transactional
    public void testDelete() {
        System.out.println("Delete Method");
        Long id = 3l;
        Boolean flag = false;
        flag = universityDao.delete(id);
        System.out.println("Record Deleted : " + flag);

        assertEquals(flag, true);
    }

    @Test
    @Transactional
    public void testRetriveAll() {
        List<University> universitys;
        universitys = universityDao.retriveAll();
        assertNotNull(universitys);
    }

    @Test
    @Transactional
    public void testAll() {
        University entity = new University();
        Long id;

        // For Create Method
        entity.setName("Ganapat");
        entity.setRegno("12345");
        id = universityDao.create(entity);
        assertNotNull(id);

        // For Retrive Method
        entity = (University) universityDao.retriveById(id);
        System.out.println("Record Found: " + entity);
        assertNotNull(entity);

        // For update Method
        entity = (University) universityDao.retriveById(id);
        entity.setName("HNGU");
        entity.setRegno("00000");
        entity = universityDao.update(entity);
        assertNotNull(entity);

        // For delete Method
        Boolean flag = false;
        flag = universityDao.delete(id);
        assertEquals(flag, true);

        // For Retirve all
        List<University> universitys;
        universitys = universityDao.retriveAll();
        assertNotNull(universitys);
    }
}
