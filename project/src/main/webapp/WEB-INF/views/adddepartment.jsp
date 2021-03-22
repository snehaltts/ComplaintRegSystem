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
        url="jdbc:mysql://localhost:3306/demo"
        user="root" password="root"
    />

    <sql:query var="listUsers"   dataSource="${myDS}">	
        SELECT * FROM employee where role = 3;
    </sql:query>
     
    <div align="center">
     <form action="/adddepartment" method= "POST">
 <h2>Allotment of Department </h2>
					<center>
						<table width="50%" cellpadding="5">
							<thead>
								<tr>
									<th colspan="2">Assign Department</th>
								</tr>
							</thead>
							<tbody>
								    <tr>
                        <td>Department</td>
                        <td><select class="form-control" id="dept" name = "departmentname">
											<option>Development</option>
											<option>HR</option>
											<option>IT</option>
											<option>Security</option>
											<option>Other</option>
									</select> </td>
                    </tr> 
							<tr>
									<td>Issue</td>
									<td><select class="form-control" id="issue" name = "issuetype">
											<option>HR Department</option>
											<option>IT Department</option>
											<option>Security</option>
											<option>Other</option>
									</select> </td>
								</tr>
					
								<tr>
									<td>Select Employee</td>
									<td><select id = "eid" name="empid">
    <c:forEach items="${listUsers.rows}" var="employee">
        <option value="${employee.emp_id}">${employee.emp_id} : ${employee.emp_name}</option>
    </c:forEach>
</select></td>
								</tr>
							
								<tr>
									<td><input type="submit" value="Submit"
										class='btn btn-primary' /></td>
									<td><input type="reset" value="Reset"
										class='btn btn-danger' /></td>
											<%-- <td><a href="/checkuser?empid=<%=s%>&pass=123"
										class='btn btn-danger' >Back To Dashboard</a></td> --%>
								</tr>

							</tbody>
						</table>
					</center>
				</form>
    </div>

</body>
</html>