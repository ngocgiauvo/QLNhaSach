package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	
	public String layTenTheLoai(int id) {
		Session session = sessionFactory.openSession();
		String name = "";
		
		try {
			String hql = "FROM Theloai WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setInteger("id", id);
			
			List<Theloai> temp = (List<Theloai>) query.list();
			
			if(temp.size() > 0) {
				name = temp.get(0).getTenTheLoai();
			}
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		
		return name;
	}
}
