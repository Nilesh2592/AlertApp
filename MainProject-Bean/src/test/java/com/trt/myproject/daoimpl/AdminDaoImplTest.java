/*
 *
 */
package com.trt.myproject.daoimpl;

import com.trt.mainproject.dao.AdminDao;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.Admin;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
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
public class AdminDaoImplTest {

    @Autowired
    private AdminDao adminDao;

//    @Test
//    @Transactional
    public void testCreate() {
        System.out.println("Create Method");
        Admin entity = new Admin();
        Long id;
        entity.setName("Nilesh");
        entity.setEmail("abc@gmail.com");
        entity.setMobile("9624007066");
        id = adminDao.create(entity);

        assertNotNull(entity.getId());
    }

//    @Test
//    @Transactional
    public void testRetiveById() {
        System.out.println("Search By Id Mentod");
        Admin entity = new Admin();
        Long id = 1l;
        entity = (Admin) adminDao.retriveById(id);
        System.out.println(entity);
        assertNotNull(entity);
    }

//    @Test
//    @Transactional
    public void testUpdate() {
        System.out.println("Update Method");
        Admin entity = new Admin();
        entity = adminDao.retriveById(1l);
        System.out.println("Searched Entity " + entity);
        entity.setName("Nilesh");
        entity.setEmail("nilesh@gmail.com");
        entity.setMobile("9624007066");
        entity = adminDao.update(entity);
        System.out.println("Updated Entity : " + entity);
        assertNotNull(entity);
    }

//    @Test
//    @Transactional
    public void testDelete() {
        System.out.println("Delete Method");
        Long id = 1l;
        Boolean flag = false;
        flag = adminDao.delete(id);
        assertEquals(flag, true);
    }

//    @Test
//    @Transactional
    public void testRetriveAll() {
        List<Admin> admins;
        admins = adminDao.retriveAll();
        assertNotNull(admins);
    }

//    @Test
//    @Transactional
    public void testRetirveAll() {

    }

    @Test
    public void testAll() {
        Admin entity = new Admin();
        Long id;

        // For create Method
        entity.setName("Nilesh");
        entity.setEmail("abc@gmail.com");
        entity.setMobile("9624007066");
        id = adminDao.create(entity);
        assertNotNull(entity.getId());

        // For Retrive Method.
        entity = (Admin) adminDao.retriveById(id);
        System.out.println(entity);
        assertNotNull(entity);

        // For Update Method
        entity = adminDao.retriveById(id);
        entity.setName("Nil");
        entity.setEmail("nil@gmail.com");
        entity.setMobile("8238099184");
        entity = adminDao.update(entity);
        assertNotNull(entity);

        // For Delete Method
        Boolean flag = false;
        flag = adminDao.delete(id);
        assertEquals(flag, true);

        // For Retrive All
        List<Admin> admins;
        admins = adminDao.retriveAll();
        assertNotNull(admins);
    }
}
