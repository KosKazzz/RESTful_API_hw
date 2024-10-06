package com.kaz.demo.services;

import com.kaz.demo.MySessionFactory;
import com.kaz.demo.models.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {
    @Autowired
    MySessionFactory factory;

    public boolean isUserNameValid(User user) {
        return user.getName() != null;
    }

    public boolean isPinCodeValid(User user) {
        return String.valueOf(user.getPin()).length() == 4;
    }

    public boolean isUserInDb(User user) {
        User isUser = null;
        try {
            Session session = factory.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            isUser = session.get(User.class, user.getName());
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());//lol
        } finally {
            factory.closeFactory();
        }
        return isUser != null;
    }
}
