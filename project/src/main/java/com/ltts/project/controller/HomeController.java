package com.ltts.project.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.project.Dao.*;
import com.ltts.project.model.*;

@RestController
public class HomeController {
	
	@Autowired
	EmployeeDao md;
	@Autowired
	ComplaintDao cd;
	
	@RequestMapping("/hi")
	public String firstMethod() {
		return "Hello SpringBoot";
	}
	
	@RequestMapping(" ")
	public ModelAndView secondMethod() {
		return new ModelAndView("index");
	}
	@RequestMapping("/registration")
	public ModelAndView registerUser() {
		return new ModelAndView("registration");
	}
	@RequestMapping("/login")
	public ModelAndView loginUser() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/putcomplaint")
	public ModelAndView fileCompaint()
	{
		return new ModelAndView("complaint");
	}
	@RequestMapping("/welcome")
	public ModelAndView home()
	{
		return new ModelAndView("welcome");
	}
//	@RequestMapping("/allcomplaints")
//	public ModelAndView viewComplaints()
//	{
//		return new ModelAndView("complaints");
//	}
	@RequestMapping(value="adduser", method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req, Model model) {
		ModelAndView mv=null;
		String empId = req.getParameter("empid");
		String empName=req.getParameter("empname");
		String designation=req.getParameter("designation");
		String department=req.getParameter("department");
		String immediateSupervisor ="KNS";
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		
		
	//	ApplicationContext ac=new ClassPathXmlApplicationContext();
		Employee m=new Employee(empName, designation, department, immediateSupervisor, password, email , mobile, empId);
		System.out.println("***** INSIDE CONTROLLER ****"+m);
		boolean b=md.InsertMember(m);
		if(b==false) {
			mv=new ModelAndView("success");
			model.addAttribute("msg", "Successfully Added.. ");
			
		}
		else {
			mv=new ModelAndView("error");
			model.addAttribute("msg", "Error due to Connection");
			
		}		
		return mv;
	}
	
	
	@RequestMapping(value = "addcomplaint", method=RequestMethod.POST)
	public ModelAndView addCompaint(HttpServletRequest req, Model model)

	{
		ModelAndView mv = null;
		String complaintType = req.getParameter("complaintType");
		LocalDate requestDate = java.time.LocalDate.now();
		String complaintSubject = req.getParameter("complaintSubject");
		String complaintDescription = req.getParameter("complaintDescription");
		int compInc;
		if(complaintType.equalsIgnoreCase("HR Department"))
		{
			compInc = 1;
		}
		else 	if(complaintType.equalsIgnoreCase("IT Department"))
		{
			compInc = 2;
		}
		else 	if(complaintType.equalsIgnoreCase("Security"))
		{
			compInc = 3;
		}
		else 
		{
			compInc = 4;
		}
		String requestStatus = "Pending";
		String empId = req.getParameter("sender");
		System.out.println("this value" + empId);
		Complaint c = new Complaint (1,complaintType, requestDate,complaintDescription ,compInc,complaintSubject , requestStatus, empId);
		System.out.println("***** INSIDE CONTROLLER ****"+c);
		boolean b=cd.InsertComplaint(c);
		if(b==false) {
			mv=new ModelAndView("success");
			mv = new ModelAndView("welcome");
			model.addAttribute("msg", "Successfully Added.. ");
			
		}
		else {
			mv=new ModelAndView("error");
			model.addAttribute("msg", "Error due to Connection");
			
		}		
		return mv;
	
	}
	@RequestMapping(value="checkuser")
	public ModelAndView checkUser(HttpServletRequest req, Model model) {
		ModelAndView mv=null;
		String empId=req.getParameter("empid");
		String pass=req.getParameter("pass");
		Employee e = md.getMemberByEmpId(empId);

		if(e !=null) {		
				if(pass.equals(e.getPassword())) {

				model.addAttribute("value", e.getEmpName());
				mv=new ModelAndView("welcome");
			}
			else {
				model.addAttribute("msg", "Password Wrong");
				mv=new ModelAndView("login");
			}
		}
		else {
			System.out.println("Reached and Not found");
//			model.addAttribute("msg", "User Not Found Please Register");
			mv=new ModelAndView("login");
		}
		return mv;
	}
	@RequestMapping(value="updatecomplaint")
	public ModelAndView updateComplaint(HttpServletRequest req, Model model) {
		ModelAndView mv=null;
		String empId=req.getParameter("empid");
		String pass=req.getParameter("pass");
		Employee e = md.getMemberByEmpId(empId);

		if(e !=null) {		
				if(pass.equals(e.getPassword())) {

				model.addAttribute("value", e.getEmpName());
				mv=new ModelAndView("welcome");
			}
			else {
				model.addAttribute("msg", "Password Wrong");
				mv=new ModelAndView("login");
			}
		}
		else {
			System.out.println("Reached and Not found");
//			model.addAttribute("msg", "User Not Found Please Register");
			mv=new ModelAndView("login");
		}
		return mv;
	}
	@RequestMapping("/viewcomplaints")
	public ModelAndView viewAllComplaints(Model model) {
		ModelAndView mv=new ModelAndView("complaints");
		List<Complaint> li=cd.getAllComplaints();
		
		model.addAttribute("list", li);
		
		return mv;
	}
	   @RequestMapping("/edit/{complaint_id}")
       public ModelAndView editComp(Model model) {
           ModelAndView mav = new ModelAndView("feedback");
//           Product product = service.get(id);
//           mav.addObject("product", product);
            
           return mav;
       }
       

}
