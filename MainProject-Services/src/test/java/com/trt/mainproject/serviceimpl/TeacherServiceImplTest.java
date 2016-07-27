/*
 * 
 */
package com.trt.mainproject.serviceimpl;

import com.trt.mainproject.config.ApplicationContextConfigService;
import com.trt.mainproject.services.TeacherService;
import com.trt.mainproject.common.CommonUtilJava;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.Teacher;
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
public class TeacherServiceImplTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void testCreate() {
        System.out.println("create method >>>");
        Teacher teacher = new Teacher();
        Long id = null;
        teacher.setName("Nilesh");
        teacher.setUname("Nilesh");
        teacher.setPass(CommonUtilJava.encryptedPassword("123"));
        teacher.setMobile("9624007066");
        teacher.setUni_id(1l);
        id = teacherService.create(teacher);
        assertNotNull(id);
    }

//    @Test
//    @Transactional
    public void testRetriveById() {
        System.out.println("retriveById Method >>>");
        Teacher teacher = new Teacher();
        Long id = 2l;
        teacher = (Teacher) teacherService.retriveById(id);
        System.out.println("Teacher Entity : " + teacher);
        assertNotNull(teacher);
    }

//    @Test
//    @Transactional
    public void testUpdate() {
        System.out.println("Update Method >>>>");
        Teacher teacher = new Teacher();

        teacher.setName("Dhaval");
        teacher.setUname("Dhaval");
        teacher.setPass(CommonUtilJava.encryptedPassword("12345"));
        teacher.setMobile("7600422543");
        teacher = teacherService.update(teacher);
        assertNotNull(teacher);
    }

//    @Test
//    @Transactional
    public void testDelete() {
        System.out.println("Delete Method >>>");
        Long id = 4l;
        Boolean flag = false;
        flag = teacherService.delete(id);
        assertEquals(flag, true);
    }

//    @Test
//    @Transactional
    public void testRetriveAll() {
        List<Teacher> teachers;
        teachers = teacherService.retriveAll();
        System.out.println(teachers);
        assertNotNull(teachers);
    }

//    @Test
    public void testCrud() {
        Teacher teacher = new Teacher();
        Long id = null;

        // For Create Method
        teacher.setName("Dhaval");
        teacher.setUname("dhaval");
        teacher.setPass(CommonUtilJava.encryptedPassword("dhaval"));
        teacher.setMobile("7600422543");
        id = teacherService.create(teacher);
        assertNotNull(id);

        // For Retrive Method
        teacher = (Teacher) teacherService.retriveById(id);
        System.out.println("Teacher Entity : " + teacher);
        assertNotNull(teacher);

        // For Update Method
        teacher.setName("Nilesh");
        teacher.setUname("nilesh");
        teacher.setPass(CommonUtilJava.encryptedPassword("nilesh"));
        teacher.setMobile("9624007066");
        teacher = teacherService.update(teacher);
        assertNotNull(teacher);

        // For Delete Method
        Boolean flag = false;
        flag = teacherService.delete(id);
        assertEquals(flag, true);

        // For Retrive All
        List<Teacher> teachers;
        teachers = teacherService.retriveAll();
        assertNotNull(teachers);
    }
}
