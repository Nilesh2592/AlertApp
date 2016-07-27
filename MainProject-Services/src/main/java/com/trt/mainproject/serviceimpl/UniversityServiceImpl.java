/*
 * 
 */
package com.trt.mainproject.serviceimpl;

import com.trt.mainproject.dao.UniversityDao;
import com.trt.mainproject.entity.University;
import com.trt.mainproject.services.UniversityService;
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
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityDao universityDao;

    @Override
    @Transactional
    public Long create(University university) {
        Long id = null;
        try {
            if (universityDao != null && university != null) {
                id = universityDao.create(university);
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
    public University retriveById(Long id) {
        University university = new University();
        try {
            if (universityDao != null && university != null) {
                university = (University) universityDao.retriveById(id);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return university;
    }

    @Override
    @Transactional
    public University update(University university) {
        try {
            if (universityDao != null && university != null) {
                university = (University) universityDao.update(university);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return university;
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        Boolean flag = null;
        try {
            if (universityDao != null && id != null) {
                flag = universityDao.delete(id);
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
    public List<University> retriveAll() {
        List<University> universitys = null;
        try {
            if (universityDao != null) {
                universitys = universityDao.retriveAll();
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return universitys;
    }

}
