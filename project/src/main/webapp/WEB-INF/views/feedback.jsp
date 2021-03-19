<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Alive</h1>
</body>
</html> --%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    
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
<title>Solution</title>
</head>
<body>
<%-- <h1>View All Complaints</h1>
${list} --%>

    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/hibernate"
        user="root" password="root"
    />
    <%--  <% int s= Integer.parseInt(request.getParameter("complaint_id")); 
     	Complaint c=new Complaint();
     	c.setComplaintId(s);
     %> --%>
     <%
     Object s = request.getAttribute("javax.servlet.forward.request_uri");
     /* /* out.print(s);  */
	String s1 = s.toString();
	  /* out.print(s1); */  
	  String scvn[] = s1.split("\\/"); 
	 
	  
     %>
    <sql:query var="listUsers"   dataSource="${myDS}">	
        SELECT * FROM complaint where complaint_id = <%= scvn[2] %>;
    </sql:query>
     
    <div align="center">
     <form action="updatecomplaint">
 <h2>Complaint Description </h2>
        <table border="1" cellpadding="5">
           
            <tr>
                <th>ComplaintId</th>
                 <th>Complaint Subject</th>
                <th>Complaint Description</th>
                
            </tr>
            <c:forEach var="complaint" items="${listUsers.rows}">
                <tr>
                 <td><c:out value="${complaint.complaint_id}" /></td>
                   <td><c:out value="${complaint.complaint_subject}" /></td>
                  <td><c:out value="${complaint.complaint_description}" /></td>
			
                </tr>
                
            </c:forEach>
            <a href="/welcome">Back To DashBoard</a>
        </table><br>
        	Give Solution: <textarea></textarea>
        	 <tr>
                        <td><input type="submit" value="Submit" class = "btn btn-primary"/></td>
                        <td><a href="/viewcomplaints"  class = 'btn btn-danger' >Cancel</a></td>
                    </tr>
                    </form>
    </div>

</body>
</html>