package dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Sach;
import entities.Taikhoan;

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
	
	public ArrayList<Sach> timKiemSach(String ten, String tacgia, int loai) {
		Session session = sessionFactory.openSession();
		ArrayList<Sach> list = null;
		
		try {
			session.beginTransaction();
			
			String hql = "FROM Sach WHERE tenSach LIKE :ten AND tacGia LIKE :tacgia";
			if(loai > 0) {
				hql += " AND theLoai = :loai";
			}
			
			Query query = session.createQuery(hql);
			query.setParameter("ten", "%" + ten + "%");
			query.setParameter("tacgia", "%" + tacgia + "%");
			
			if(loai > 0) {
				query.setInteger("loai", loai);
			}
			
			list = (ArrayList<Sach>) query.list();
			
			return list;
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}
}
