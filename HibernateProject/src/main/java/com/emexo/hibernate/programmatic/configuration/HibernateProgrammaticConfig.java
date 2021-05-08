package com.emexo.hibernate.programmatic.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Properties;

public class HibernateProgrammaticConfig {

    public static void main(String[] args) {


        Properties prop= new Properties();
        prop.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");
        prop.setProperty("hibernate.connection.username", "sa");
        prop.setProperty("hibernate.connection.password", "");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        try {

            Configuration configuration = new Configuration();
            configuration.setProperties(prop);

            configuration.addAnnotatedClass(Users.class);

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).buildServiceRegistry();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            // obtains the session
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Users user1 = new Users("Tom", "tomcat", "tom@gmail.net");
            Users user2 = (Users) session.save(user1);

            Users user = (Users) session.get(Users.class, user2.getId());

            System.out.println(user.getEmail());
            System.out.println(user.getFullName());
            System.out.println(user.getPassword());

            session.close();
            sessionFactory.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}