   
 <%@page import="com.ltts.project.model.Complaint"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Assign Role</title>
</head>
<body>
<%-- <h1>View All Complaints</h1>
${list} --%>

    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/demo"
        user="root" password="root"
    />
    <%--  <% int s= Integer.parseInt(request.getParameter("complaint_id")); 
     	Complaint c=new Complaint();
     	c.setComplaintId(s);
     %> --%>
     <%
     Object s = request.getAttribute("javax.servlet.forward.request_uri");
	 String s1 = s.toString();
	 String scvn[] = s1.split("\\/"); 
     %>
    <sql:query var="listUsers"   dataSource="${myDS}">	
        SELECT * FROM employee where emp_id = <%= scvn[2] %>;
    </sql:query>
     
    <div align="center">
     <form action="/updaterole" method= "POST">
 <h2>Update Employee Role </h2>
        <table border="1" cellpadding="5">
           
            <tr>
                <th>EmployeeId</th>
                 <th>Employee Name</th>
                <th>Employee Designation</th>
                
                
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                 <td><c:out value=  "${user.emp_id}" /></td>
                   <td><c:out value="${user.emp_name}" /></td>
                  <td><c:out value= "${user.designation}" /></td>
					<%-- <td><c:out value= "${user.designation}" /></td> --%>
                </tr>
                
            </c:forEach>
            <a href="/checkuser?emp_id=99003666&pass=123">Back To DashBoard</a>
        </table><br>
       <div style= "width: 500px;  margin: auto;  border: 3px solid #73AD21;">
          <input type = "hidden" value = "<%= scvn[2] %>" name = "empid"/><br>
        	Assign Role: <select class="form-control" id="roletype" name = "rolename">
											<option>HR Department</option>
											<option>IT Department</option>
											<option>Security</option>
											<option>Other</option>
									</select>
       </div>
     
                        <input type="submit" value="Submit" class = "btn btn-primary"/>
                     	<a href="/allusers"  class = 'btn btn-danger' >Cancel</a>
                    
                    </form>
    </div>

</body>
</htm