/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trt.myproject.authenticatedaoimpl;

import com.trt.mainproject.authenticatedaoimpl.AuthenticateDaoImpl;
import com.trt.mainproject.common.CommonUtilJava;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.Teacher;
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
public class AuthenticateDaoImplTest {

    @Autowired
    private AuthenticateDaoImpl authenticateDaoImpl;

//    @Test
//    @Transactional
    public void testCheckLogin() {

        // sucess test case
        String uname = "dhaval";
        String pass = "dhaval";
        String encPassStr = CommonUtilJava.encryptedPassword(pass);
        System.out.println(encPassStr);
        Teacher teacher = null;
        teacher = authenticateDaoImpl.checkLogin(uname, encPassStr, true);
        System.out.println("User Object  >>> " + teacher);
        String checkUname = teacher.getUname();
        assertNotNull(teacher);
        assertEquals(checkUname, uname);

        // faliurer test case
        String uname1 = "wrong";
        String pass1 = "wrong";
        Teacher teacher1;
        teacher1 = authenticateDaoImpl.checkLogin(uname1, pass1, true);
        assertNull(teacher1);
    }
}
