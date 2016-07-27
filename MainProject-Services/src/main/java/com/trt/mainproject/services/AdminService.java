/*
 * 
 */
package com.trt.mainproject.services;


import com.trt.mainproject.entity.Admin;
import java.util.List;

/**
 *
 * @author nilay
 */
public interface AdminService {
    public Long create(Admin admin);
    public Admin retriveById(Long id);
    public Admin update(Admin admin);
    public Boolean delete(Long id);
    public List<Admin> retriveAll();
}
