/*
 * 
 */
package com.trt.mainproject.userwebservicesimpl;

import com.trt.mainproject.entity.Alert;
import com.trt.mainproject.services.AlertService;
import com.trt.mainproject.userwebservices.AlertWebService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nilay
 */
@RestController
public class AlertWebServiceImpl implements AlertWebService {

    @Autowired
    private AlertService alertService;

    @Override
    public List<Alert> getAllAlerts() {
        List<Alert> alerts;
        alerts = alertService.retriveAll();
        return alerts;
    }

    @Override
    public Alert getAlertById(@PathVariable Long id) {
        Alert alert;
        alert = alertService.retriveById(id);
        return alert;
    }

    @Override
    public Long addAlert(@RequestBody Alert alert) {
        Long id = alertService.create(alert);
        return id;
    }

    @Override
    public Alert updateAlert(@RequestBody Alert alert) {
        alert = alertService.update(alert);
        return alert;
    }

    @Override
    public Boolean deleteAlert(@PathVariable Long id) {
        Boolean flag = false;
        flag = alertService.delete(id);
        return flag;
    }

    @Override
    public Alert retriveAlertByUserId(@RequestParam(value = "tId", required = true) Long tId, 
                                      @RequestParam(value = "aId", required = true) int aId) {
        Alert alert;
        alert = alertService.retriveAlertByUserId(tId, aId);
        return alert;
    }
}
