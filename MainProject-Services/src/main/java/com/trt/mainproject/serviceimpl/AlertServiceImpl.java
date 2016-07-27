/*
 * 
 */
package com.trt.mainproject.serviceimpl;

import com.trt.mainproject.dao.AlertDao;
import com.trt.mainproject.dao.TeacherDao;
import com.trt.mainproject.entity.Alert;
import com.trt.mainproject.entity.Teacher;
import com.trt.mainproject.services.AlertService;
import java.util.HashMap;
import java.util.Iterator;
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
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertDao alertDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    @Transactional
    public Long create(Alert alert) {
        Long id = null;
        try {
            if (alertDao != null && alert != null) {
                id = alertDao.create(alert);
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return id;
    }

    @Override
    @Transactional
    public Alert retriveById(Long id) {
        Alert alert = new Alert();
        try {
            if (alertDao != null && id != null) {
                alert = (Alert) alertDao.retriveById(id);
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return alert;
    }

    @Override
    @Transactional
    public Alert update(Alert alert) {
        try {
            if (alertDao != null && alert != null) {
                alert = (Alert) alertDao.update(alert);
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return alert;
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        Boolean flag = null;
        try {
            if (alertDao != null && id != null) {
                flag = alertDao.delete(id);
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
    public List<Alert> retriveAll() {
        List<Alert> alerts = null;
        try {
            if (alertDao != null) {
                alerts = alertDao.retriveAll();
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return alerts;
    }

    @Override
    @Transactional
    public Alert retriveAlertByUserId(Long tId, int aId) {
        Alert alert = null;
        List<Alert> alerts;
        Long techUniId = null;

        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            if (teacherDao != null && tId != null) {
                Teacher teacher = teacherDao.retriveById(tId);
                if (teacher != null) {
                    techUniId = teacher.getUni_id();
                    if (techUniId != null) {
                        hashMap.put("aid", aId);
                        hashMap.put("uni_id", techUniId);
                        if (alertDao != null) {
                            alerts = alertDao.retriveByCriteria(hashMap);
                            if (alerts != null) {
                                Iterator iterator = alerts.iterator();
                                while (iterator.hasNext()) {
                                    alert = (Alert) iterator.next();
                                }
                            }
                        }
                    }
                }
            }

        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return alert;
    }
}
