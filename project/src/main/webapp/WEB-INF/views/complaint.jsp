<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%   
Cookie cookie = null;
Cookie[] cookies = null;

// Get an array of Cookies associated with the this domain
cookies = request.getCookies();
String s = "";
if( cookies != null ) {
  
   for (int i = 1; i < cookies.length; i++) {
      cookie = cookies[i];
      s  = cookie.getValue();
   }
} else {
	
   out.println("<h2>No cookies founds</h2>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1>Complaint Form:</h1>
		<div class="card">
			<div class="card-body">
				<form method="post" action="addcomplaint">
					<center>
						<table width="50%" cellpadding="5">
							<thead>
								<tr>
									<th colspan="2">Provide Description for your Complaint</th>
								</tr>
							</thead>
							<tbody>
							
								<tr>
								<%out.print(s);%>
							<input type = "hidden" name = "eid" value ="<%=s%>" />
									<td>Complaint Type</td>
									<td><select class="form-control" id="complainttype" name = "complaintType">
											<option>HR Department</option>
											<option>IT Department</option>
											<option>Security</option>
											<option>Other</option>
									</select> </td>
								</tr>
						<!-- 		<tr>
									<td>Complaint Subcategory</td>
									<td><select class="form-control" id="complainttype" name = "complaintType">
											<option>HR Department</option>
											<option>IT Department</option>
											<option>Security</option>
											<option>Other</option>
									</select> </td>
								</tr> -->
								<tr>
									<td>Complaint Subject</td>
									<td><input type="text" name="complaintSubject" value="" style = "width:350px"/></td>
								</tr>
								<tr>
									<td>Complaint Description</td>
									<td><textarea type="text" name="complaintDescription" value="" style = "width:350px"></textarea></td>
								</tr>
								<tr>
									<td><input type="submit" value="Submit"
										class='btn btn-primary' /></td>
									<td><input type="reset" value="Reset"
										class='btn btn-danger' /></td>
											<td><a href="/checkuser?empid=<%=s%>&pass=123"
										class='btn btn-danger' >Back To Dashboard</a></td>
								</tr>

							</tbody>
						</table>
					</center>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
]
