
/*
 * This is for implementation of GenericDao<T> 
 */
package com.trt.mainproject.genricdaoimpl;

import com.trt.mainproject.genricdao.GenericDao;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 *
 * @author nilay
 * @param <T>
 */
//@TransactionConfiguration(defaultRollback = false)
public class GenericDaoImpl<T> implements GenericDao<T> {

    private Class<T> type;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @Autowired
    private HibernateTemplate hibernateTemplate;

    // for Date Paramaeter use in refelection.
    private Class[] paramDate = new Class[1];
    // For Boolean parameter use in refelection.
    private Class[] paramBoolean = new Class[1];
    private Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    private Method method;

    @Override
//    @Transactional
    public Long create(T entity) throws HibernateException {
        Long id = null;
        if (hibernateTemplate != null && entity != null) {
            paramDate[0] = Date.class;
            paramBoolean[0] = Boolean.class;
            try {
                method = cls.getDeclaredMethod("setCrDate", paramDate);
                method.invoke(entity, new Date());
                method = cls.getDeclaredMethod("setUpdate", paramDate);
                method.invoke(entity, (Object) null);
                method = cls.getDeclaredMethod("setIsActive", paramBoolean);
                method.invoke(entity, true);
                method = cls.getDeclaredMethod("setIsArchive", paramBoolean);
                method.invoke(entity, false);

                hibernateTemplate.save(entity);

                method = cls.getDeclaredMethod("getId", null);
                id = (Long) method.invoke(entity, null);
//                method = cls.getDeclaredMethod("isActive", null);
//                method.invoke(entity, true);
//                method = cls.getDeclaredMethod("isArchive", null);
//                method.invoke(entity, false);
            } catch (IllegalAccessException accessException) {
                accessException.printStackTrace();
            } catch (IllegalArgumentException argumentException) {
                argumentException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            } catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            } catch (SecurityException securityException) {
                securityException.printStackTrace();
            }
        } else {
            System.out.println("Null Value Found In Dao Class");
        }
        return id;
    }

    @Override
//    @Transactional
    public T retriveById(Long id) throws HibernateException {
        T t = null;
        if (hibernateTemplate != null && id != null) {
            t = (T) hibernateTemplate.get(type, id);
        } else {
            System.out.println("Null Value Found In Dao Class");
        }
        return t;
    }

    @Override
//    @Transactional
    public T update(T entity) throws HibernateException {
        if (hibernateTemplate != null && entity != null) {
            paramDate[0] = Date.class;
            try {
                method = cls.getDeclaredMethod("setUpdate", paramDate);
                method.invoke(entity, new Date());
            } catch (IllegalAccessException accessException) {
                accessException.printStackTrace();
            } catch (IllegalArgumentException argumentException) {
                argumentException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            } catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            } catch (SecurityException securityException) {
                securityException.printStackTrace();
            }

            hibernateTemplate.update(entity);
        } else {
            System.out.println("Null Value Found In Dao Class");
        }
        return entity;
    }

    @Override
//    @Transactional
    public Boolean delete(Long id) throws HibernateException {
        Boolean flag = null;
        T t = null;
        if (hibernateTemplate != null && id != null) {
            t = (T) hibernateTemplate.get(type, id);
            paramBoolean[0] = Boolean.class;
            if (t != null) {
                try {
                    method = cls.getDeclaredMethod("setIsActive", paramBoolean);
                    method.invoke(t, false);
                    method = cls.getDeclaredMethod("setIsArchive", paramBoolean);
                    method.invoke(t, true);
                } catch (IllegalAccessException accessException) {
                    accessException.printStackTrace();
                } catch (IllegalArgumentException argumentException) {
                    argumentException.printStackTrace();
                } catch (InvocationTargetException invocationTargetException) {
                    invocationTargetException.printStackTrace();
                } catch (NoSuchMethodException noSuchMethodException) {
                    noSuchMethodException.printStackTrace();
                } catch (SecurityException securityException) {
                    securityException.printStackTrace();
                }
                hibernateTemplate.update(t);
            } else {
                System.out.println("Record Not Found");
            }
            flag = true;
        } else {
            System.out.println("Null Value Found In Dao Class");
        }
        return flag;
    }

    @Override
    public List<T> retriveAll() throws HibernateException {
        List<T> list = null;
        Criteria criteria = null;
        if (hibernateTemplate != null) {
            criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(type);
            criteria.add(Restrictions.eq("isActive", true));
        }
        return list = criteria.list();
    }

    @Override
    public List<T> retriveByCriteria(HashMap<String, Object> hashMap) throws HibernateException {
        List<T> t = null;
        if (hibernateTemplate != null && hashMap != null) {
            Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(type);
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));

            }
            t = criteria.list();
        }

        return t;
    }

}
