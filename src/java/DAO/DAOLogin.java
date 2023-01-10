/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import POJO.PaladiumUtil;
import POJO.TblUser;

/**
 *
 * @author setephen
 */
public class DAOLogin {
    public List<TblUser> getBy(String uName, String uPass)
    {
        Transaction trans = null;
        TblUser us = new TblUser();
        List<TblUser> user = new ArrayList();
        Session session = PaladiumUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser where username=:uName AND password=:uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            us = (TblUser) query.uniqueResult();
            user = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
       return user;
    }
    


    public String add_user(TblUser user){
    
        Transaction trans = null;
        Session session = PaladiumUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
            return "admin";
        } catch (Exception e) {
            System.out.println(e);
        } return "logingagal";
    }
}
