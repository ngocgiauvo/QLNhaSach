package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Nhapsach;

public class NhapSachDAO {
	public NhapSachDAO() {
		
	}
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public int nhapSach(Nhapsach ns) {
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.save(ns);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		
		return ns.getId();
	}
}
