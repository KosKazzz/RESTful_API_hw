package com.kaz.demo;

import com.kaz.demo.models.User;
import com.kaz.demo.models.UserAccount;
import com.kaz.demo.services.UserValidation;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;

@Component
public class MyDTO {
    @Autowired
    MySessionFactory factory;
    @Autowired
    UserValidation userValidation;

    public String addNewUser(User user) {
        if (!userValidation.isUserNameValid(user)) {
            return "userName is null!";
        }
        if (!userValidation.isPinCodeValid(user)) {
            return "invalid pin!";
        }

        UserAccount userAccount = new UserAccount();
        Random random = new Random();
        int account = random.nextInt(900000) + 99999;
        userAccount.setAccount(account);
        userAccount.setAccount_balance(0);
        userAccount.setUser(user);
        try {
            Session session = factory.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.persist(user);
            session.persist(userAccount);
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());//lol
        } finally {
            factory.closeFactory();
        }

        return "New user added!";
    }

    public String addMoney(User user, int addAmount) {
        if (!userValidation.isUserInDb(user)) {
            return "there is no such user ";
        }

        try {
            Session session = factory.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int newBalance;
            String userName = user.getName();
            Query<Integer> query =  session.createQuery("SELECT account_balance FROM user_accounts JOIN users ON " +
                    " user_accounts.user_id = users.id  WHERE users.id = :userName", Integer.class)
                    .setParameter("userName", userName);
            int balance = query.getSingleResult();
            balance = balance+addAmount;
            session.createMutationQuery("");
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());//lol
        } finally {
            factory.closeFactory();
        }
        return "ok";
    }

    public String withdrawMoney(User user, int withdrawAmount) {
        return "ok";
    }

    public String transferMoney(User userDebit, int targetAccount, int transferAmount) {
        return "ok";
    }
}
