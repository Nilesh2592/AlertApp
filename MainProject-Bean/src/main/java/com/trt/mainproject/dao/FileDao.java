/*
 * 
 */
package com.trt.mainproject.dao;

import com.trt.mainproject.entity.Document;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nilay
 */
@Repository
public interface FileDao {

    public Boolean saveFile(Document document);
}
