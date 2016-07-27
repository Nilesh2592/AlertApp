/*
 * 
 */
package com.trt.mainproject.userwebservices;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nilay
 */
@RestController
@SessionAttributes(value = "alertTypeBean", types = {AlertType.class})
public class AlertController {

    @ModelAttribute("alertTypeBean")
    public AlertType ceatrAlertType() {
        AlertType alertType = new AlertType();
        alertType.setId(1);
        alertType.setName("Fier Alert");
        return alertType;
    }

    @RequestMapping(value = "/alerttype")
    public ModelAndView getAlertType(HttpSession session) {
        AlertType alertType = (AlertType) session.getAttribute("alertTypeBean");
        return new ModelAndView(alertType.toString());
    }
}
