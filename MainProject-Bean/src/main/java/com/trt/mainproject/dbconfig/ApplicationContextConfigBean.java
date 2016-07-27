/* 
 * This class is configuration calss of the database.
 * and, it contain database connection information.
 * it is added common project.
 */
package com.trt.mainproject.dbconfig;

import com.trt.mainproject.authenticatedao.AuthenticateDao;
import com.trt.mainproject.authenticatedaoimpl.AuthenticateDaoImpl;
import com.trt.mainproject.dao.AdminDao;
import com.trt.mainproject.dao.AlertDao;
import com.trt.mainproject.dao.FileDao;
import com.trt.mainproject.dao.TeacherDao;
import com.trt.mainproject.dao.UniversityDao;
import com.trt.mainproject.daoimpl.AdminDaoImpl;
import com.trt.mainproject.daoimpl.AlertDaoImpl;
import com.trt.mainproject.daoimpl.FileDaoImpl;
import com.trt.mainproject.daoimpl.TeacherDaoImpl;
import com.trt.mainproject.daoimpl.UniversityDaoImpl;
import com.trt.mainproject.entity.Admin;
import com.trt.mainproject.entity.Alert;
import com.trt.mainproject.entity.Document;
import com.trt.mainproject.entity.Teacher;
import com.trt.mainproject.entity.University;
import java.io.IOException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author nilay
 */
@Configuration
@ComponentScan("com.trt.mainproject")
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
public class ApplicationContextConfigBean {

//    public String getPropertyValue(String key) throws IOException {
//        InputStream inputStream;
//        String propValue = "";
//        try {
//            Properties properties = new Properties();
//            String propFileName = "hibernate.properties";
//            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//            if (inputStream != null) {
//                properties.load(inputStream);
//            } else {
//                throw new FileNotFoundException("Property File " + propFileName + " Not Found");
//            }
//            propValue = properties.getProperty(key);
//
//        } catch (IOException iOException) {
//            System.out.println(iOException.getMessage());
//        }
//        return propValue;
//    }
    @Value("${databaseURL}")
    private String databaseURL;

    @Value("${driverClass}")
    private String driverClass;

    @Value("${dbUser}")
    private String dbUser;

    @Value("${password}")
    private String password;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${hibernate.Dialect}")
    private String hibernateDialect;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateAuto;

//    This bean is requier for access the value of property file.
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() throws IOException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(databaseURL);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addAnnotatedClasses(Teacher.class, University.class, Admin.class, Alert.class, Document.class);
        sessionBuilder.setProperty("hibernate.show_sql", hibernateShowSql);
        sessionBuilder.setProperty("hibernate.dialect", hibernateDialect);
        sessionBuilder.setProperty("hibernate.hbm2ddl.auto", hibernateAuto);
//        sessionBuilder.setProperty("hibernate.connection.autocommit", "false");

//        sessionBuilder.setProperty("maxPoolSize", "200");
        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "hibernateTemplate")
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }

//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver getCommonsMultipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(20971520);   // 20MB
//        multipartResolver.setMaxInMemorySize(1048576);  // 1MB
//        return multipartResolver;
//    }
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager gettranTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

    @Autowired
    @Bean
    public TeacherDao getTeacherDao() {
        return new TeacherDaoImpl();
    }

    @Autowired
    @Bean
    public UniversityDao getUniversityDao() {
        return new UniversityDaoImpl();
    }

    @Autowired
    @Bean
    public AdminDao getAdminDao() {
        return new AdminDaoImpl();
    }

    @Autowired
    @Bean
    public AlertDao getAlertDao() {
        return new AlertDaoImpl();
    }

    @Autowired
    @Bean
    public AuthenticateDao getAuthenticateDao() {
        return new AuthenticateDaoImpl();
    }

    @Autowired
    @Bean
    public FileDao getFileDao() {
        return new FileDaoImpl();
    }
}
