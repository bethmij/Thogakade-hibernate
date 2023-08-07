package lk.ijse.lib.config;

import lk.ijse.lib.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig sessionFactoryConfig;
    private SessionFactory sessionFactory;

    private SessionFactoryConfig(){
        sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return (sessionFactoryConfig==null) ? sessionFactoryConfig=new SessionFactoryConfig():sessionFactoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}
