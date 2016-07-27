/*
 * this class is read value from property file.
 * File path is // F:\TRT\MainProject\MainProject-Bean\src\main\resources\config\config.properties
 */
package com.trt.mainproject.getpropvalue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author nilay
 */
public class GetPropertyValue {

    private String result;
    private InputStream inputStream;

    public String getPropValues() throws IOException {

        try {
            Properties properties = new Properties();
            String propFileName = "hiberna.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property File " + propFileName + " Not Found");
            }
            String user = properties.getProperty("driverClass");
            String langauge = properties.getProperty("databaseURL");

            result = user + " << >> " + langauge;
            System.out.println(result);

        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return result;
    }
}
