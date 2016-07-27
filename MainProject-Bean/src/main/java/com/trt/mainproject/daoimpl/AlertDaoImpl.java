/*
 * implementation of above override method or Aditional method.
 */
package com.trt.mainproject.daoimpl;

import com.trt.mainproject.dao.AlertDao;
import com.trt.mainproject.entity.Alert;
import com.trt.mainproject.genricdaoimpl.GenericDaoImpl;

/**
 *
 * @author nilay
 */
public class AlertDaoImpl extends GenericDaoImpl<Alert> implements AlertDao {

    public AlertDaoImpl() {
        super(Alert.class);
    }

}
