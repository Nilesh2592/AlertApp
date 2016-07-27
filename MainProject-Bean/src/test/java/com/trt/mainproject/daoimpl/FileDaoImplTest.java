/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trt.mainproject.daoimpl;

import com.trt.mainproject.dao.FileDao;
import com.trt.mainproject.dbconfig.ApplicationContextConfigBean;
import com.trt.mainproject.entity.Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
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
public class FileDaoImplTest {

    @Autowired
    private FileDao fileDao;

    /**
     * Test of saveFile method, of class FileDaoImpl.
     */
    @Test
    public void testSaveFile() throws IOException {
        Boolean flag = false;
        Document document = new Document();
        document.setFileName("demo3.txt");

        File file = new File("E:\\New Text Document.txt");
        byte[] fileUpload = new byte[(int) file.length()];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileUpload);
            fileInputStream.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        document.setUserFile(fileUpload);

        flag = fileDao.saveFile(document);
        assertEquals(flag, true);
    }
}
