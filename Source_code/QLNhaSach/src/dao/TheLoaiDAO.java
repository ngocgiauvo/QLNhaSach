package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Theloai;

public class TheLoaiDAO {
	public TheLoaiDAO() {
		
	}
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public ArrayList<Theloai> layTheLoai() {
		Session session = sessionFactory.openSession();
		ArrayList<Theloai> list = null;
		
		try {
			session.beginTransaction();
			list = (ArrayList<Theloai>) session.createQuery("from Theloai").list();
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
