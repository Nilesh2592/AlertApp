/*
 * 
 */
package com.trt.mainproject.serviceimpl;

import com.trt.mainproject.dao.AdminDao;
import com.trt.mainproject.entity.Admin;
import com.trt.mainproject.services.AdminService;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nilay
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional
    public Long create(Admin admin) {
        Long id = null;
        try {
            if (adminDao != null && admin != null) {
                id = adminDao.create(admin);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return id;
    }

    @Override
    @Transactional
    public Admin retriveById(Long id) {
        Admin admin = new Admin();
        try {
            if (adminDao != null && id != null) {
                admin = (Admin) adminDao.retriveById(id);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return admin;
    }

    @Override
    @Transactional
    public Admin update(Admin admin) {
        try {
            if (adminDao != null && admin != null) {
                admin = (Admin) adminDao.update(admin);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return admin;
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        Boolean flag = false;
        try {
            if (adminDao != null && id != null) {
                flag = adminDao.delete(id);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return flag;
    }

    @Override
    @Transactional
    public List<Admin> retriveAll() {
        List<Admin> admins = null;
        try {
            if (adminDao != null) {
                admins = adminDao.retriveAll();
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return admins;
    }
}
