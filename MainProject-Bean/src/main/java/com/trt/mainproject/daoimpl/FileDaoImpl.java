/*
 * 
 */
package com.trt.mainproject.daoimpl;

import com.trt.mainproject.dao.FileDao;
import com.trt.mainproject.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 *
 * @author nilay
 */
public class FileDaoImpl implements FileDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Boolean saveFile(Document document) {
        Boolean flag = false;
        
            hibernateTemplate.save(document);
            flag = true;
        return flag;
    }
}
