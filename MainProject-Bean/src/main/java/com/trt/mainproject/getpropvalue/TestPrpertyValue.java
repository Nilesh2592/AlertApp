/*
 * 
 */
package com.trt.mainproject.getpropvalue;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nilay
 */
public class TestPrpertyValue {

    public static void main(String[] args) {
        GetPropertyValue testPropertyValue = new GetPropertyValue();
        try {
            testPropertyValue.getPropValues();
        } catch (IOException ex) {
            Logger.getLogger(TestPrpertyValue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
