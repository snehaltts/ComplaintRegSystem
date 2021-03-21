<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
    </head>
    <body>
     <div class="container">
  <h1>Registration Form:</h1>
  <div class="card">
   <div class="card-body">
    
        <form method="post" action="adduser">
            <center>
            <table width="50%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Provide your personal Information</th>
                    </tr>
                </thead>
                <tbody>
                 <tr>
                        <td>Employee ID</td>
                        <td><input type="text" name="empid" value="" /></td>
                    </tr>
                    <tr>
                        <td>Full Name</td>
                        <td><input type="text" name="empname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Designation</td>
                        <td><input type="text" name="designation" value="" /></td>
                    </tr>
                      <tr>
                        <td>Department</td>
                        <td><input type="text" name="department" value="" /></td>
                    </tr> 
                      <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                      <tr>
                        <td>Mobile</td>
                        <td><input type="text" name="mobile" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" class = 'btn btn-primary'/></td>
                        <td><input type="reset" value="Reset" class = 'btn btn-danger'/></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="login">Click Here To Login</a></td>
                    </tr>
                        <tr>
                         <a href="/">Back To Dashboard</a></td>
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