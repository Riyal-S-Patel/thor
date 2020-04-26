<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark"> <span
		class="navbar-brand mb-0 h1"><h2 style="color: orange">X-workz
			CM</h2></span> <span class="navbar-text"> <a href="register.jsp">Register</a>
		<a href="home.jsp">Home</a></nav>
	<br>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<form class="col-md-12" action="userLogin.do" method="post">
					<h3>${loginmsg}</h3>
					<h3>${block}</h3>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" placeholder="Enter email"
							name="email">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" placeholder="Enter Password"
							name="password">
					</div>
					<div class="row justify-content-center">
						<button type="submit" class="btn col-md-6 btn-success">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<div>
		<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
		<div class="container text-center">
			<small style="color: white">@ 2020 Copyright &copy;
				xworkz.com</small>
		</div>
		</footer>
	</div>
</body>
</html>
