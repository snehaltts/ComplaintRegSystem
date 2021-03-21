<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
         
   Cookie username = new Cookie("empid", request.getParameter("empid")); 
   response.addCookie( username );

%>
 
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body bgcolor="white">
          <div class="card">
          <div class="card-body">
        <form action="checkuser">
            <center>
            <table border="0" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Page</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>EmployeeId</td>
                       
                        <td><input type="text" name="empid"/></td>
         					 					
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" class = "btn btn-primary"/></td>
                        <td><input type="reset" value="Reset" class = 'btn btn-danger' /></td>
                    </tr>
                    <tr>
                        <td colspan="2">New User <a href="registration" >Register Here</a></td>
                        
                    </tr>
                      
                </tbody>
            </table>
            </center>
        </form>
              </div> </div>
    </body>
</html>