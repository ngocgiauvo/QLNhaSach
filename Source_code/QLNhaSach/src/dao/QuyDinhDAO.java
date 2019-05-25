package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Quydinh;

public class QuyDinhDAO {
	public QuyDinhDAO() {
		
	}
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public ArrayList<Quydinh> layDSQuyDinh() {
		Session session = sessionFactory.openSession();
		ArrayList<Quydinh> list = null;
		
		try {
			session.beginTransaction();
			list = (ArrayList<Quydinh>) session.createQuery("FROM Quydinh WHERE hieuLuc = 1").list();
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
