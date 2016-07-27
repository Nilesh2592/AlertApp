/*
 * 
 */
package com.trt.mainproject.serviceimpl;

import com.trt.mainproject.config.ApplicationContextConfigService;
import com.trt.mainproject.services.UniversityService;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.University;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
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
public class UniversityServiceImplTest {

    @Autowired
    private UniversityService universityService;

    @Test
    public void testCreate() {
        System.out.println("create method");
        University university = new University();
        Long id = null;
        university.setName("GNU Uni.");
        university.setRegno("12345");
        id = universityService.create(university);
        assertNotNull(id);
    }

//    @Test
//    @Transactional
    public void testRetriveById() {
        System.out.println("retriveById Method");
        University university = new University();
        Long id = 2l;
        university = (University) universityService.retriveById(id);
        System.out.println("Teacher Entity : " + university);
        assertNotNull(university);
    }

//    @Test
//    @Transactional
    public void testUpdate() {
        System.out.println("Update Method");
        University university = new University();
        university.setName("aaaaa");
        university.setRegno("aaaaa");
        university = (University) universityService.update(university);
        assertNotNull(university);

    }

//    @Test
//    @Transactional
    public void testDelete() {
        System.out.println("Delete Method");
        Long id = 1l;
        Boolean flag = false;
        flag = universityService.delete(id);
        assertEquals(flag, true);
    }

//    @Test
//    @Transactional
    public void testRetriveAll() {
        List<University> universitys;
        universitys = universityService.retriveAll();
        System.out.println(universitys);
        assertNotNull(universitys);
    }

//    @Test
    public void testCrud() {
        University university = new University();
        Long id = null;

        // For Create Method
        university.setName("Gujarat Uni.");
        university.setRegno("12345");
        id = universityService.create(university);
        assertNotNull(id);

        // For update Method
        university = (University) universityService.retriveById(id);
        System.out.println("Teacher Entity : " + university);
        assertNotNull(university);

        // For Update Method
        university.setName("aaaaa");
        university.setRegno("aaaaa");
        university = (University) universityService.update(university);
        assertNotNull(university);

        // For Delete Method
        Boolean flag = false;
        flag = universityService.delete(id);
        assertEquals(flag, true);

        // For Retrive All
        List<University> universitys;
        universitys = universityService.retriveAll();
        assertNotNull(universitys);
    }
}
