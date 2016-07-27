/*
 * 
 */
package com.trt.mainproject.userwebservices;

import com.trt.mainproject.entity.Alert;
import com.trt.mainproject.entity.Teacher;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nilay
 */
public interface AlertWebService {

    @RequestMapping(value = "/alert", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Alert> getAllAlerts();

    @RequestMapping(value = "/alert/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Alert getAlertById(@PathVariable Long id);

    @RequestMapping(value = "/alert", method = RequestMethod.POST, headers = "Accept=application/json")
    public Long addAlert(@RequestBody Alert alert);

    @RequestMapping(value = "/alert", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Alert updateAlert(@RequestBody Alert alert);

    @RequestMapping(value = "/alert/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public Boolean deleteAlert(@PathVariable Long id);

    @RequestMapping(value = "/alert/param", method = RequestMethod.GET, headers = "Accept=application/json")
    public Alert retriveAlertByUserId(@RequestParam(value = "tId", required = true) Long tId, 
                                      @RequestParam(value = "aId", required = true) int aId);
}
