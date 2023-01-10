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
import POJO.Pelanggan;
import POJO.PaladiumUtil;

/**
 *
 * @author syada
 */
public class DAOPelanggan {
    // Untuk menampilkan data ke tabel
    public List<Pelanggan> retrveTblpelanggan() {
        List listPelanggan = new ArrayList();
        Transaction transaction = null;
        Session session = PaladiumUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Pelanggan");
            listPelanggan = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listPelanggan;
    }
    
     // untuk mencari/seach data, manipulasi data seperti delete, edit, dan search
    public List<Pelanggan> getbyID(String idPelanggan) {
        Pelanggan pelanggan = new Pelanggan();
        List<Pelanggan> listPelanggan = new ArrayList();
        Transaction transaction = null;
        Session session = PaladiumUtil.getSessionFactory().openSession();
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Pelanggan where id = id");
            query.setString("id", idPelanggan);
            pelanggan = (Pelanggan) query.uniqueResult();
            listPelanggan = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listPelanggan;
    }
    
    // untuk add data
    public void addPelanggan(Pelanggan pelanggan){
        Transaction transaction = null;
        Session session = PaladiumUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(pelanggan);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // untuk delete berdcasarkan id
    public void deleteUser(Integer idPelanggan) {
        Transaction transaction = null;
        Session session = PaladiumUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Pelanggan usr = (Pelanggan) session.load(Pelanggan.class, new Integer(idPelanggan));
            session.delete(usr);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // untuk edit
    public void editUser(Pelanggan pelanggan) {
        Transaction transaction = null;
        Session session = PaladiumUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(pelanggan);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
