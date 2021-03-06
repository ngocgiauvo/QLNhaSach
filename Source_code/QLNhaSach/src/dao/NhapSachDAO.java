package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Nhapsach;

public class NhapSachDAO {
	public NhapSachDAO() {
		
	}
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void nhapSach(ArrayList<Nhapsach> nsList) {
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			for(Nhapsach ns : nsList) {
				session.save(ns);
			}
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}
}
