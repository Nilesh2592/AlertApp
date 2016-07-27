/*
 * 
 */
package com.trt.myproject.daoimpl;

import com.trt.mainproject.dao.AlertDao;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.Alert;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;
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
public class AlertDaoImplTest {

    @Autowired
    private AlertDao alertDao;

//    @Test
    public void testCreate() {
        System.out.println("Create Method");
        Alert entity = new Alert();
        Long id;
        entity.setAid(1);
        entity.setMsg("Fire Message");
        id = alertDao.create(entity);

        assertNotNull(entity.getId());
    }

//    @Test
    public void testRetiveById() {
        System.out.println("Search By Id Mentod");
        Alert entity = new Alert();
        Long id = 1l;
        entity = (Alert) alertDao.retriveById(id);
        System.out.println("Record Found: " + entity);
        assertNotNull(entity);
    }

//    @Test
    public void testUpdate() {
        System.out.println("Update Method");
        Alert entity = new Alert();
        entity = alertDao.retriveById(1l);
        entity.setAid(2);
        entity.setMsg("Sefty Message");
        entity = alertDao.update(entity);
        System.out.println("Updated Entity : " + entity);
        assertNotNull(entity);
    }

//    @Test
    public void testDelete() {
        System.out.println("Delete Method");
        Long id = 1l;
        Boolean flag = false;
        flag = alertDao.delete(id);
        System.out.println("Record Deleted : " + flag);
        assertEquals(flag, true);
    }

//    @Test
    public void testRetriveAll() {
        List<Alert> alerts;
        alerts = alertDao.retriveAll();
        assertNotNull(alerts);
    }

    @Test
    public void testRetriveUserById() {
        System.out.println("Retrive By User Id Test >>>");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("aid", 1);
        hashMap.put("uni_id", 1l);
        List<Alert> alerts;
        alerts = alertDao.retriveByCriteria(hashMap);
        System.out.println(alerts);
        assertNotNull(alerts);
    }

//    @Test
//    @Transactional
    public void testAll() {
        Alert entity = new Alert();
        Long id;

        // For create Method
        entity.setAid(1);
        entity.setMsg("Fire Message");
        id = alertDao.create(entity);
        assertNotNull(entity.getId());

        // For Retrive method
        entity = (Alert) alertDao.retriveById(id);
        System.out.println("Record Found: " + entity);
        assertNotNull(entity);

        // for update method
        entity = alertDao.retriveById(id);
        entity.setAid(11);
        entity.setMsg("Sefty Message");
        entity = alertDao.update(entity);
        assertNotNull(entity);

        // for delete Method
        Boolean flag = false;
        flag = alertDao.delete(id);
        System.out.println("Record Deleted : " + flag);
        assertEquals(flag, true);

        // For Retrive All
        List<Alert> alerts;
        alerts = alertDao.retriveAll();
        assertNotNull(alerts);
    }
}
