/*
 *
 */
package com.trt.mainproject.serviceimpl;

import com.trt.mainproject.config.ApplicationContextConfigService;
import com.trt.mainproject.services.AlertService;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.Alert;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
public class AlertServiceImplTest {
    
    @Autowired
    private AlertService alertService;

    @Test
//    @Transactional
    public void testCreate() {
        System.out.println("create method");
        Alert alert = new Alert();
        Long id = null;
        alert.setAid(1);
        alert.setMsg("Police Message");
        alert.setUni_id(1l);
        id = alertService.create(alert);
        assertNotNull(id);
    }

//    @Test
//    @Transactional
    public void testRetriveById() {
        System.out.println("retriveById Method");
        Alert alert = new Alert();
        Long id = 2l;
        alert = (Alert) alertService.retriveById(id);
        System.out.println("Teacher Entity : " + alert);
        assertNotNull(alert);
    }

//    @Test
//    @Transactional
    public void testUpdate() {
        System.out.println("Update Method");
        Alert alert = new Alert();
        alert.setAid(11);
        alert.setMsg("update Message");
        alert = (Alert) alertService.update(alert);
        assertNotNull(alert);
    }

//    @Test
//    @Transactional
    public void testDelete() {
        System.out.println("Delete Method");
        Long id = 1l;
        Boolean flag = false;
        flag = alertService.delete(id);
        assertEquals(flag, true);
    }

//    @Test
//    @Transactional
    public void testRetriveAll() {
        List<Alert> alerts;
        alerts = alertService.retriveAll();
        System.out.println(alerts);
        assertNotNull(alerts);
    }

    // Valid Test Case.
//    @Test
//    @Transactional
    public void testRetriveAlertByUserId() {
        Alert alert = null;
        alert = alertService.retriveAlertByUserId(1l, 1);
        Assert.assertNotNull(alert);
    }

    // Pass the null value Test Case.
//    @Test
//    @Transactional
    public void testRetriveAlertByUserIdPassesNull() {
        Alert alert = null;
        alert = alertService.retriveAlertByUserId(null, 1);
        Assert.assertNull(alert);
    }

    // Id not in the database.
//    @Test
//    @Transactional
    public void testRetriveAlertByUserIdNullValue() {
        Alert alert = null;
        alert = alertService.retriveAlertByUserId(10l, 10);
        Assert.assertNull(alert);
    }

//    @Test
    public void testCrud() {
        Alert alert = new Alert();
        Long id = null;

        // For Create Method
        alert.setAid(1);
        alert.setMsg("Fier Message");
        id = alertService.create(alert);
        assertNotNull(id);

        // For Retrive By Id Method 
        alert = (Alert) alertService.retriveById(id);
        System.out.println("Teacher Entity : " + alert);
        assertNotNull(alert);

        // For Update Method
        alert.setAid(11);
        alert.setMsg("Sefty Message");
        alert = (Alert) alertService.update(alert);
        assertNotNull(alert);

        // For Delete Method
        Boolean flag = false;
        flag = alertService.delete(id);
        assertEquals(flag, true);

        // For Alert Method
        List<Alert> alerts;
        alerts = alertService.retriveAll();
        assertNotNull(alerts);
    }
}
