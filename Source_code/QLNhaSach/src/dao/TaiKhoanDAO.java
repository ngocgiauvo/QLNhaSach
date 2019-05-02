package dao;

import java.util.ArrayList;

import org.hibernate.Query;
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
	
	public int KiemTraDangNhap(String username, String pass) {
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			
			String hql = "FROM Taikhoan WHERE tenDangNhap = :tendangnhap and matKhau = :matkhau";
			Query query = session.createQuery(hql);
			query.setString("tendangnhap", username);
			query.setString("matkhau", pass);
			
			ArrayList<Taikhoan> list = (ArrayList<Taikhoan>) query.list();
			
			if(list.size() > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return 0;
	}
}
