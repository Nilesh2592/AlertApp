/*
 * 
 */
package com.trt.mainproject.services;


import com.trt.mainproject.entity.Alert;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author nilay
 */
public interface AlertService {

    public Long create(Alert alert);

    public Alert retriveById(Long id);

    public Alert update(Alert alert);

    public Boolean delete(Long id);

    public List<Alert> retriveAll();

    public Alert retriveAlertByUserId(Long tId, int aId);

}
