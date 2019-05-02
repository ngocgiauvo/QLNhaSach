package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.*;

public class TaiKhoanDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
	public TaiKhoanDAO() {
		
	}
	
	public ArrayList<Taikhoan> getAll() {
		Session session = sessionFactory.openSession();
		ArrayList<Taikhoan> list = null;
		
		try {
			session.beginTransaction();
			   
			list = (ArrayList<Taikhoan>) session.createQuery("from Taikhoan").list();
			for (Taikhoan tk: list) {
			    System.out.println(tk.getTenDangNhap());
			}
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
