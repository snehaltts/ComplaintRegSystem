package com.ltts.project.controller;

import java.time.LocalDate;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Autowired
	departmentDao dd;
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
	public ModelAndView fileCompaint() {
		return new ModelAndView("complaint");
	}

	@RequestMapping("/welcome")
	public ModelAndView home() {
		return new ModelAndView("welcome");
	}

	@RequestMapping("/allusers")
	public ModelAndView users() {
		return new ModelAndView("users");
	}

	@RequestMapping("/allresolvers")
	public ModelAndView resolvers() {
		return new ModelAndView("resolvers");
	}

	@RequestMapping("/allcomplaints")
	public ModelAndView viewComplaints() {
		return new ModelAndView("complaintsadmin");
	}

	@RequestMapping("/pendingcomplaints")
	public ModelAndView viewPendingComplaints() {
		return new ModelAndView("pendingcomplaints");
	}

	@RequestMapping("/resolvedcomplaints")
	public ModelAndView viewResolvedComplaints() {
		return new ModelAndView("resolvedcomplaints");
	}
	@RequestMapping("/adddepartment")
	public ModelAndView assignRole() {
		return new ModelAndView("adddepartment");
	}

	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req, Model model) {
		ModelAndView mv = null;
		String empId = req.getParameter("empid");
		String empName = req.getParameter("empname");
		String designation = req.getParameter("designation");
		String department = req.getParameter("department");
		String immediateSupervisor = "KNS";
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		int role = 3;
		String assignedRole = "NOT_ASSIGNED";
		String hasAssignedRole = "NO";

		Employee m = new Employee(empName, designation, department, immediateSupervisor, password, email, mobile, empId,
				role, assignedRole, hasAssignedRole);
		System.out.println("***** INSIDE CONTROLLER ****" + m);
		boolean b = md.InsertMember(m);
		if (b == false) {
			mv = new ModelAndView("success");
			model.addAttribute("msg", "Successfully Added.. ");

		} else {
			mv = new ModelAndView("error");
			model.addAttribute("msg", "Error due to Connection");

		}
		return mv;
	}

	@RequestMapping(value = "addcomplaint", method = RequestMethod.POST)
	public ModelAndView addCompaint(HttpServletRequest req, Model model) {
		ModelAndView mv = null;
		String complaintType = req.getParameter("complaintType");
		LocalDate requestDate = java.time.LocalDate.now();
		String complaintSubject = req.getParameter("complaintSubject");
		String complaintDescription = req.getParameter("complaintDescription");
		int compInc;
		int resolver;

		if (complaintType.equalsIgnoreCase("HR Department")) {
			compInc = 1;
			resolver = 1111;
		} else if (complaintType.equalsIgnoreCase("IT Department")) {
			compInc = 2;
			resolver = 2222;
		} else if (complaintType.equalsIgnoreCase("Security")) {
			compInc = 3;
			resolver = 3333;
		} else {
			compInc = 4;
			resolver = 4444;
		}
		String requestStatus = "Pending";
		String requestFeedback = "Not Reviewed Yet";

		String empId = req.getParameter("eid");

		System.out.println("this value" + empId);
		Complaint c = new Complaint(1, complaintType, requestDate, complaintDescription, compInc, complaintSubject,
				requestStatus, empId, requestFeedback, resolver);
		System.out.println("***** INSIDE CONTROLLER ****" + c);
		boolean b = cd.InsertComplaint(c);
		if (b == false) {
			mv = new ModelAndView("successcomplaint");
			/* mv = new ModelAndView("welcome"); */
			model.addAttribute("msg", "Successfully Added.. ");

		} else {
			mv = new ModelAndView("error");
			model.addAttribute("msg", "Error due to Connection");

		}
		return mv;

	}

	@RequestMapping(value = "checkuser")
	public ModelAndView checkUser(HttpServletRequest req, Model model, ModelMap mm) {
		ModelAndView mv = null;
		String empId = req.getParameter("empid");
		String pass = req.getParameter("pass");
		Employee e = md.getMemberByEmpId(empId);

		if (e != null) {
			if (pass.equals(e.getPassword())) {
				if (e.getRole() == 1) {
					mm.put("empId", e.getEmpId());
					model.addAttribute("value", e.getEmpName());
//						model.addAttribute("empId", e.getEmpId());
					model.addAttribute("role", e.getRole());
					mv = new ModelAndView("WelcomeAdmin");
				} else if (e.getRole() == 2) {
					model.addAttribute("value", e.getEmpName());
					model.addAttribute("empId", e.getEmpId());
					model.addAttribute("role", e.getRole());
					mv = new ModelAndView("welcomeResolver");
				} else {
					model.addAttribute("value", e.getEmpName());
					model.addAttribute("empId", e.getEmpId());
					model.addAttribute("role", e.getRole());
					mv = new ModelAndView("welcome");
				}
			} else {
				model.addAttribute("msg", "Password Wrong");
				mv = new ModelAndView("login");
			}
		} else {
			System.out.println("Reached and Not found");
//			model.addAttribute("msg", "User Not Found Please Register");
			mv = new ModelAndView("login");
		}
		return mv;
	}

	@RequestMapping("/viewcomplaints")
	public ModelAndView viewAllComplaints(Model model) {
		ModelAndView mv = new ModelAndView("complaints");
		List<Complaint> li = cd.getAllComplaints();

		model.addAttribute("list", li);

		return mv;
	}

	@RequestMapping("/edit/{complaint_id}")
	public ModelAndView editComp(Model model) {
		ModelAndView mav = new ModelAndView("feedback");
		return mav;
	}

	@RequestMapping("/editemp/{emp_id}")
	public ModelAndView editEmployee(Model model) {
		ModelAndView mav = new ModelAndView("editrole");
		return mav;
	}

	@RequestMapping(value = "updatecomplaint", method = RequestMethod.POST)
	public ModelAndView updateCompaint(HttpServletRequest req, Model model) {
		ModelAndView mv = null;
		int complaintId = Integer.parseInt(req.getParameter("id"));

		String feedback = req.getParameter("feedback");
		String requestStatus = "Resolved";

		System.out.println("***** INSIDE CONTROLLER ****");
		boolean b = cd.updateComplaint(complaintId, feedback, requestStatus);

		if (b == false) {
			mv = new ModelAndView("complaints");
			model.addAttribute("msg", "Successfully Added.. ");

		} else {
			mv = new ModelAndView("error");
			model.addAttribute("msg", "Error due to Connection");

		}
		return mv;

	}

	@RequestMapping(value = "updaterole", method = RequestMethod.POST)
	public ModelAndView updateEmployeeRole(HttpServletRequest req, Model model) {
		ModelAndView mv = null;
		String employeeId = req.getParameter("empid");
		String roleName = req.getParameter("rolename");
		int role = 2;
		System.out.println("***** INSIDE CONTROLLER ****");
		boolean b = md.updateRole(employeeId, roleName, role);

		if (b == false) {
			mv = new ModelAndView("users");
			model.addAttribute("msg", "Successfully Added.. ");

		} else {
			mv = new ModelAndView("error");
			model.addAttribute("msg", "Error due to Connection");

		}
		return mv;

	}
	
	@RequestMapping(value = "adddepartment", method = RequestMethod.POST)
	public ModelAndView addDepartment(HttpServletRequest req, Model model) {
		ModelAndView mv = null;
		String departmentName = req.getParameter("departmentname");
		String empId = req.getParameter("empid");
		String issueType = req.getParameter("issuetype");
		String roleAssigned = "Yes";
		int role = 2;
		System.out.println("this value" + empId);
		Department d = new Department(departmentName, empId, issueType ,1);
		System.out.println("***** INSIDE CONTROLLER ****" + d);
		boolean b = dd.InsertDepartment(d);
		boolean bb = md.updateRo(empId, roleAssigned);
		boolean bbb = md.updateRole(empId, departmentName, role);
		if (b == false) {
			mv = new ModelAndView("successcomplaint");
			/* mv = new ModelAndView("welcome"); */
			model.addAttribute("msg", "Successfully Added.. ");

		} else {
			mv = new ModelAndView("error");
			model.addAttribute("msg", "Error due to Connection");

		}
		return mv;

	}


}
