/*
 * 
 */
package com.trt.mainproject.serviceimpl;

import com.trt.mainproject.config.ApplicationContextConfigService;
import com.trt.mainproject.services.AdminService;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.Admin;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author nilay
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfigService.class, ApplicationContextConfigBean.class})
public class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testCreate() {
        System.out.println("create method");
        Admin admin = new Admin();
        Long id = null;
        admin.setName("Nil");
        admin.setEmail("Nil@gmail.com");
        admin.setMobile("999999999");
        admin.setUni_id(1l);
        id = adminService.create(admin);
        assertNotNull(id);
    }

//    @Test
//    @Transactional
    public void testRetriveById() {
        System.out.println("retriveById Method");
        Admin admin = new Admin();
        Long id = 1l;
        admin = (Admin) adminService.retriveById(id);
        System.out.println("Teacher Entity : " + admin);
        assertNotNull(admin);
    }

//    @Test
//    @Transactional
    public void testUpdate() {
        System.out.println("Update Method");
        Admin admin = new Admin();
        admin = (Admin) adminService.retriveById(1l);
        admin.setName("aaaa");
        admin.setEmail("aaa@gmail.com");
        admin.setMobile("11111111");
        admin = (Admin) adminService.update(admin);
        assertNotNull(admin);
    }

//    @Test
//    @Transactional
    public void testDelete() {
        System.out.println("Delete Method");
        Long id = 1l;
        Boolean flag = false;
        flag = adminService.delete(id);
        assertEquals(flag, true);
    }

//    @Test
//    @Transactional
    public void testRetriveAll() {
        List<Admin> admins;
        admins = adminService.retriveAll();
        System.out.println(admins);
        assertNotNull(admins);
    }

//    @Test
    public void testCrud() {
        Admin admin = new Admin();
        Long id = null;

        // For Create Method
        admin.setName("Nil");
        admin.setEmail("Nil@gmail.com");
        admin.setMobile("999999999");
        id = adminService.create(admin);
        assertNotNull(id);

        // For RetriveById Method
        admin = (Admin) adminService.retriveById(id);
        System.out.println("Teacher Entity : " + admin);
        assertNotNull(admin);

        // For Update Method
        admin.setName("aaaa");
        admin.setEmail("aaa@gmail.com");
        admin.setMobile("11111111");
        admin = (Admin) adminService.update(admin);
        assertNotNull(admin);

        // For Delete Method
        Boolean flag = false;
        flag = adminService.delete(id);
        assertEquals(flag, true);

        // For Retrive All
        List<Admin> admins;
        admins = adminService.retriveAll();
        assertNotNull(admins);
    }

}
