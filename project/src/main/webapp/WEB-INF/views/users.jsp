<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

<title>Employee List</title>
<style>
.not-active {
  pointer-events: none;
  cursor: default;
  text-decoration: none;
  color: black;
}</style>
</head>
<body style = "background-color:#F3EBF6;">
<%-- <h1>View All Complaints</h1>
${list} --%>

    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/demo"
        user="root" password="root"
    />
      <!-- SELECT * FROM complaint where complaint_incharge = 1; -->
    <sql:query var="listUsers"   dataSource="${myDS}">
       
        SELECT * FROM employee where role =3;
    </sql:query>
   
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Employees</h2></caption>
            <tr>
                <th>EmployeeId</th>
                <th>Employee Department</th>
                <th>Employee Designation</th>
                <th>Employee Email</th>
                <th>Employee Name</th>
                <th>Employee Supervisor</th>
                <th>Employee Mobile</th>
                <th>Action</th>
               
                
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                 <td><c:out value="${user.emp_id}" /></td>
                  <td><c:out value="${user.department}" /></td>
                   <td><c:out value="${user.designation}" /></td>
                    <td><c:out value="${user.email}" /></td>
                     <td><c:out value="${user.emp_name}" /></td>
                      <td><c:out value="${user.immediate_supervisor}" /></td>
                    <td><c:out value="${user.mobile}" /></td>
                     <td>
					
                     <a href="/editemp/${user.emp_id}" >Edit Role</a> 
                                       
                </td>
                </tr>
            </c:forEach>
            <!-- </form> -->
            <a href="checkuser?empid=99003666&pass=123">Back To DashBoard</a>
        </table>
    </div>

</body>
</html>