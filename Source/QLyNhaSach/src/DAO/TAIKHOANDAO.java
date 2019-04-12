package DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Taikhoan;

public class TAIKHOANDAO {
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	
	public boolean KiemTraDangNhap(String taikhoan,String matkhau)
    {
		Session session =sessionFactory.openSession();//tao ket noi moi
    	
    	 try {

             session.beginTransaction();

             String hql="from Taikhoan";
             Query query=session.createQuery(hql);
//             query.setString("tendangnhap", taikhoan);
//             query.setString("matkhau", matkhau);
             ArrayList<Taikhoan>dstk=(ArrayList<Taikhoan>) query.list();
             if(dstk.size()>0)
             {
            	 return true;
             }
             else
             {
            	 return false;
             }

         } catch (RuntimeException e) {

             session.getTransaction().rollback();

             e.printStackTrace();

         } finally {

             session.flush();

             session.close();

         }
    	 return false;
    }

}
