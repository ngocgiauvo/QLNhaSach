package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Hoadon;

public class HoaDonDAO {
	public HoaDonDAO() {
		
	}
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void lapHoaDon(ArrayList<Hoadon> hdList) {
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			for(Hoadon hd : hdList) {
				session.save(hd);
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
