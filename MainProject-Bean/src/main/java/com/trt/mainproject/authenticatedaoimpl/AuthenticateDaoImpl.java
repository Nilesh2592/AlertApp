/*
 * this class is implemtentation of above interface.
 */
package com.trt.mainproject.authenticatedaoimpl;

import com.trt.mainproject.authenticatedao.AuthenticateDao;
import com.trt.mainproject.entity.Teacher;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 *
 * @author nilay
 */
public class AuthenticateDaoImpl implements AuthenticateDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    private Long userId = null;

    @Override
    public Teacher checkLogin(String uname, String pass, Boolean isActive) {
        Teacher teacher = null;
        Criteria criteria;

        try {
            if (hibernateTemplate != null && uname != null && pass != null) {
                criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(Teacher.class)
                        .add(Restrictions.eq("uname", uname))
                        .add(Restrictions.eq("pass", pass));
                if (isActive != null && isActive == false) {
                    criteria.add(Restrictions.eq("isActive", isActive));
                } else {
                    criteria.add(Restrictions.eq("isActive", isActive));
                }
                List<Teacher> listResult = criteria.list();
                System.out.println("Impl Result  >>>" + listResult);
                if (listResult.size() < 1) {
                    teacher = null;
                } else {
                    Iterator iterator = listResult.iterator();
                    while (iterator.hasNext()) {
                        teacher = (Teacher) iterator.next();
                        System.out.println("Teacher Object >>>" + teacher);
                    }
                }
            } else {
                System.out.println("Null Value Found");
            }
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }

        return teacher;
    }
    
    
}
