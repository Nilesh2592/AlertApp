/*
 * 
 */
package com.trt.mainproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author nilay
 */
@Configuration
@ComponentScan(basePackages = "com.trt.mainproject")
@EnableWebMvc
public class AppConfig {

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("index.jsp");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
//useDefaultFilters = false,
//        includeFilters = {
//            @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class)
//        })
