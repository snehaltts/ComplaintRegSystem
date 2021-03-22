package com.ltts.project.Dao;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.project.model.Complaint;
import com.ltts.project.model.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private SessionFactory sf;
	
	
	public boolean InsertMember(Employee m) {
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
//		finally {
//			sf.close();
////			em.close();
//		}
		
		return b;
	}
	
	
	/*
	 * public List<Member> getMembers(){ List }
	 */
	
	public Employee getMemberByEmpId(String emp_id) {
		Employee e = (Employee)sf.openSession().get(Employee.class, emp_id);
		return e;
	
	}
	
	public boolean updateRole(String EmployeeID, String assignedRole, Integer role){
	      Session session = sf.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = 
	         (Employee)session.get(Employee.class, EmployeeID); 
	         employee.setAssignedRole( assignedRole );
	         employee.setRole(role);	
	         session.update(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return false;
	   }
	
	public boolean updateRo(String EmployeeID, String assignedRole){
	      Session session = sf.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = 
	         (Employee)session.get(Employee.class, EmployeeID);
	         employee.setHasAssignedRole(assignedRole);	
	         session.update(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return false;
	   }
	
}
