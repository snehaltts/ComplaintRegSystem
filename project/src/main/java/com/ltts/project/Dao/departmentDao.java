package com.ltts.project.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.project.model.Department;
import com.ltts.project.model.Employee;

@Repository
public class departmentDao {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private SessionFactory sf;
	
	
	public boolean InsertDepartment(Department d) {
		boolean b=false;
		Session s=null;
		try {
			s=sf.openSession();
			s.beginTransaction();
			s.save(d);
			s.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println("Exception "+e);
			b=true;
		}

		return b;
	}
	

	
	
//	 public boolean updateComplaint(Integer EmployeeID, String remarks, String status){
//	      Session session = sf.openSession();
//	      Transaction tx = null;
//	      try{
//	         tx = session.beginTransaction();
//	         Complaint employee = 
//	                    (Complaint)session.get(Complaint.class, EmployeeID); 
//	         employee.setComplaintRemark( remarks );
//	         employee.setRequestStatus( status );
//	         session.update(employee); 
//	         tx.commit();
//	      }catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      }finally {
//	         session.close(); 
//	      }
//		return false;
//	   }
	
}