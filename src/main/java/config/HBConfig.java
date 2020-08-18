package config;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HBConfig {

    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    public static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(User.class);
        configObj.addAnnotatedClass(Address.class);
        configObj.addAnnotatedClass(Cart.class);
        configObj.addAnnotatedClass(Item.class);
        configObj.addAnnotatedClass(Project.class);
        configObj.addAnnotatedClass(Employee.class);





        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
}
