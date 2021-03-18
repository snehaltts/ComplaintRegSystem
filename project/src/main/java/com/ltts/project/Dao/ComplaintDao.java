package com.ltts.project.Dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.project.model.Complaint;

@Repository
public class ComplaintDao {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private SessionFactory sf;
	
	
	public boolean InsertComplaint(Complaint m) {
		boolean b=false;
		Session s=null;
		try {
			s=sf.openSession();
			s.beginTransaction();
			
			s.save(m);
			//System.out.println(st);
			s.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println("Exception "+e);
			b=true;
		}
		finally {
			sf.close();
			em.close();
		}
		
		return b;
	}
	
	
	/*
	 * public List<Member> getMembers(){ List }
	 */
	
//	public Employee getMemberByEmai(String email) {
//		Employee m=new Employee();		
//		return m;
//	}
	
}