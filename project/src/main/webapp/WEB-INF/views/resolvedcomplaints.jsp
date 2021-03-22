
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
Cookie cookie = null;
Cookie[] cookies = null;

//Get an array of Cookies associated with the this domain
cookies = request.getCookies();
String s = "";
String s2 = "";
if (cookies != null) {

	for (int i = 1; i < cookies.length; i++) {
		cookie = cookies[i];
		s = cookie.getValue();
	}

} else {

	out.println("<h2>No cookies founds</h2>");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.not-active {
	pointer-events: none;
	cursor: default;
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>

	<%-- <h1>View All Complaints</h1>
${list} --%>

	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/demo" user="root"
		password="root" />
	<!-- SELECT * FROM complaint where complaint_incharge = 1; -->
	<sql:query var="listUsers" dataSource="${myDS}">
       
        SELECT * FROM complaint where  request_status = 'Resolved';
    </sql:query>

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Complaints</h2>
			</caption>
			<tr>
				<th>ComplaintId</th>
				<th>Complaint Description</th>
				<th>Complaint Inc</th>
				<th>Subject</th>
				<th>Type</th>
				<th>Date Of Request</th>
				<th>Status</th>
				<th>Remark</th>


			</tr>
			<c:forEach var="complaint" items="${listUsers.rows}">
				<tr>
					<td><c:out value="${complaint.complaint_id}" /></td>
					<td><c:out value="${complaint.complaint_description}" /></td>
					<td><c:out value="${complaint.complaint_incharge}" /></td>
					<td><c:out value="${complaint.complaint_subject}" /></td>
					<td><c:out value="${complaint.complaint_type}" /></td>
					<td><c:out value="${complaint.date_of_request}" /></td>
					<td><c:out value="${complaint.request_status}" /></td>
					<td><c:out value="${complaint.complaint_remark}" /></td>
					<%--            <td>

                     <a href='/edit/${complaint.complaint_id}'>Update</a>     
                               
                    
                </td> --%>
				</tr>
			</c:forEach>
			<!-- </form> -->
			<a href="http://localhost:8080/checkuser?empid=<%=s%>&pass=123">Back
				To DashBoard</a>
		</table>
	</div>

</body>
</html>