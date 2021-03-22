<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%   
Cookie cookie = null;
Cookie[] cookies = null;

// Get an array of Cookies associated with the this domain
cookies = request.getCookies();
String s = "";
if( cookies != null ) {
  
   for (int i = 0; i < cookies.length-1; i++) {
      cookie = cookies[i];
      s  = cookie.getValue();
      out.print(s.substring(0, 8));
   }
} else {
	
   out.println("<h2>No cookies founds</h2>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${msg}</h1>
<a href = "/checkuser?empid=<%=s%>&pass=123">Go to Dashboard</a>
</body>
</html>