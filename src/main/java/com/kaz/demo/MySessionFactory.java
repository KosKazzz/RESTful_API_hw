package com.kaz.demo;

import com.kaz.demo.models.Transaction;
import com.kaz.demo.models.User;
import com.kaz.demo.models.UserAccount;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MySessionFactory {

    SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        sessionFactory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserAccount.class)
                .addAnnotatedClass(Transaction.class)
                .buildSessionFactory();
        return sessionFactory;
    }
    public void closeFactory(){
        sessionFactory.close();
    }

}
