/*
 * 
 */
package com.trt.mainproject.userwebservicesimpl;

import com.trt.mainproject.entity.Admin;
import com.trt.mainproject.services.AdminService;
import com.trt.mainproject.userwebservices.AdminWebService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nilay
 */
@RestController
public class AdminWebServiceImpl implements AdminWebService {

    @Autowired
    private AdminService adminService;

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> admins;
        admins = adminService.retriveAll();
        return admins;
    }

    @Override
    public Admin getAdminById(@PathVariable Long id) {
        Admin admin;
        admin = adminService.retriveById(id);
        return admin;
    }

    @Override
    public Long addAdmin(@RequestBody Admin admin) {
        Long id = adminService.create(admin);
        return id;
    }

    @Override
    public Admin updateAdmin(@RequestBody Admin admin) {
        admin = adminService.update(admin);
        return admin;
    }

    @Override
    public Boolean deleteAdmin(@PathVariable Long id) {
        Boolean flag = false;
        flag = adminService.delete(id);
        return flag;
    }
}
