/*
 * 
 */
package com.trt.mainproject.userwebservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@RestController
@SessionAttributes(value = "abean", types = AlertType.class)
public class MyController {

    @ModelAttribute("abean")
    public List<AlertType> addStuffToRequestScope() {
        System.out.println("Inside of addStuffToRequestScope");
        List<AlertType> list = new ArrayList<AlertType>();
        AlertType bean1 = new AlertType();
        bean1.setId(1);
        bean1.setName("Fier");
        AlertType bean2 = new AlertType();
        bean2.setId(2);
        bean2.setName("Police");
        list.add(bean1);
        list.add(bean2);
        return list;
    }

    @RequestMapping("/alertType")
    public Model requestHandlingMethod(Model model, HttpServletRequest request, HttpSession session, SessionStatus status) {
        System.out.println("Inside of dosomething handler method");

        System.out.println("--- Model data ---");
        Map modelMap = model.asMap();
        for (Object modelKey : modelMap.keySet()) {
            Object modelValue = modelMap.get(modelKey);
            System.out.println(modelKey + " -- " + modelValue);
        }   
        
//        System.out.println("=== Request data ===");
//        java.util.Enumeration reqEnum = request.getAttributeNames();
//        while (reqEnum.hasMoreElements()) {
//            String s = (String) reqEnum.nextElement();
//            System.out.println(s);
//            System.out.println("==" + request.getAttribute(s));
//        }
//        String message = "Data Inserted";
        return (Model) modelMap;
    }
         //  ... the rest of the controller
}
