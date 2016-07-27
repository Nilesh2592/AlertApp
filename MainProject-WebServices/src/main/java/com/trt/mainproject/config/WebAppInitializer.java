/*
 * 
 */
package com.trt.mainproject.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author nilay
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext acwac = new AnnotationConfigWebApplicationContext();
        acwac.register(AppConfig.class);
        acwac.setServletContext(sc);
        Dynamic dynamic = sc.addServlet("dispatcher", new DispatcherServlet(acwac));
        dynamic.addMapping("/*");
        dynamic.setLoadOnStartup(1);
    }
}
