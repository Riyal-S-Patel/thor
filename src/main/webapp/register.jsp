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
			CM</h2></span> <span class="navbar-text"> <a href="login.jsp">Login</a> <a
		href="index.jsp">Home</a></nav>
	<br>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<form class="col-md-12" action="registerUser.do" method="post">
					<div class="row justify-content-center">
						<h3>
							<u>User Profile</u>
						</h3>
					</div>
					<%-- <h3>${data}</h3> --%>
					<h3>${register}</h3>
					<br>
					<h3>${password}</h3>
					<br>
					<div class="form-group">
						<label for="username">User Id</label> <input type="text"
							class="form-control" id="userid" placeholder="Enter User Id"
							name="userId"><span>${data.userId}</span>
					</div>

					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" placeholder="Enter email"
							name="email"><span>${data.email}</span>
					</div>

					<div class="form-group">
						<label for="password">Phone No</label> <input type="text"
							class="form-control" id="phoneno" placeholder="Enter phoneNumber"
							name="phoneNo"><span>${data.phoneNo}</span>
					</div>
					<div>
						<label for="sel1">----Select---</label> <select
							class="form-control" id="sel1" name="courseType">
							<option>Development</option>
							<option>Quality Assurance</option>
						</select>
					</div>

					<br>
					<div>
						<label> Agree </label> <label class="radio-inline"> <input
							type="radio" name="isAgree" value="agree"> Agree
						</label> <label class="radio-inline"> <input type="radio"
							name="isAgree" value="disAgree"> Dis-Agree <span>${data.isAgree}</span>
					</div>
					<br>
					<div class="row justify-content-center">
						<button type="submit" class="btn col-md-6 btn-success">Register</button>
					</div>
				</form>
			</div>
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
