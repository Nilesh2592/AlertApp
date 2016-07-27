/*
 * This is for Authenticateion for exa. login logout, forgot password etc.
 */
package com.trt.mainproject.authenticateservices;

/**
 *
 * @author nilay
 */
public interface AuthenticateService {

    public Boolean login(String uname, String pass);
//    public void logout(Long id);
}
