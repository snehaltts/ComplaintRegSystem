<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title >Complaint Management System</title>
</head>
<body>
<h1 style = "text-align:center">Complaint Management System</h1><br><br>
<a href="registration">Registration</a> <br><br>
<a href="login">Login</a> 
</body>
</html> -->

<!DOCTYPE html>
<html>
<head>
<style>
footer {
	background-color: blue;
	padding: 10px;
	text-align: center;
	color: white;
}

body {
	background-color: #F3EBF6;
	font-family: 'Ubuntu', sans-serif;
}

.main {
	background-color: #FFFFFF;
	width: 400px;
	height: 400px;
	margin: 7em auto;
	border-radius: 1.5em;
	box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}

.button {
	background-color: blue; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}

.button1 {
	background-color: Orange; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

.color {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}

.sign {
	padding-top: 40px;
	color: #8C55AA;
	font-family: 'Ubuntu', sans-serif;
	font-weight: bold;
	font-size: 23px;
}

form.form1 {
	padding-top: 20px;
}

form.form2 {
	padding-top: 20px;
}

form.form3 {
	padding-top: 20px;
}

.pass {
	width: 76%;
	color: rgb(38, 50, 56);
	font-weight: 700;
	font-size: 14px;
	letter-spacing: 1px;
	background: rgba(136, 126, 126, 0.04);
	padding: 10px 20px;
	border: none;
	border-radius: 20px;
	outline: none;
	box-sizing: border-box;
	border: 2px solid rgba(0, 0, 0, 0.02);
	margin-bottom: 50px;
	margin-left: 46px;
	text-align: center;
	margin-bottom: 27px;
	font-family: 'Ubuntu', sans-serif;
}

.un:focus, .pass:focus {
	border: 2px solid rgba(0, 0, 0, 0.18) !important;
}

.submit {
	cursor: pointer;
	border-radius: 5em;
	color: #fff;
	background: linear-gradient(to right, #9C27B0, #E040FB);
	border: 0;
	padding-left: 40px;
	padding-right: 40px;
	padding-bottom: 10px;
	padding-top: 10px;
	font-family: 'Ubuntu', sans-serif;
	margin-left: 35%;
	font-size: 13px;
	box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
}

@media ( max-width : 600px) {
	.main {
		border-radius: 0px;
	}
}
</style>
<title>Complaint Management</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="/scripts/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style = "background:https://www.google.com/url?sa=i&url=https%3A%2F%2Fcloudcherry.com%2Fblog%2Fdesigning-customer-complaint-management-system%2F&psig=AOvVaw3msgy8LW4Wl3Au94QdZuxA&ust=1616471087521000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNiLrbCJw-8CFQAAAAAdAAAAABAQ">
	<h1 style="text-align: center">Complaint Management System</h1>
	<br>
	<br>

	<nav class="navbar navbar-default" role="navigation"
		style="background: blue; color: white;"></nav>
	<div></div>
	<div class="main">
		<p class="sign" align="center">Welcome</p>
		<form class="form1" action="" method="get" target="_blank">
			<a type="button" class="btn btn-default" href="login"
				style="margin-left: 130px">Login</a> <a type="button"
				class="btn btn-default navbar-btn" href="registration"
				style="margin-left: 20px">Sign up</a>
		</form>

		<form class="form3" action="" method="get" target="_blank"></form>
	</div>

	<footer>
		<p>Complaint Management Inc.</p>
	</footer>
</body>
</html>