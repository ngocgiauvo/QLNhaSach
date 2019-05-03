package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Sach;

public class SachDAO {
	public SachDAO() {
		
	}
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public ArrayList<Sach> layDSSach() {
		Session session = sessionFactory.openSession();
		ArrayList<Sach> list = null;
		
		try {
			session.beginTransaction();
			list = (ArrayList<Sach>) session.createQuery("from Sach").list();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return list;
	}
}
