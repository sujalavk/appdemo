
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="header.jsp"%>
<html>
<head>
<title>Register</title>
</head>
<body class="bg-dark">
	<div class="container-fluid" id="body-container">
		<div class="d-flex justify-content-center">
			<div id="register_controls" class="row bg-light">
				<div class="col">
					<h3>Register</h3>
					<p>Create your account and start shopping with us today.</p>
					<form:form action="addUser" modelAttribute="addUser">
						<div class="row">
							<div class="col">
								<form:input path="name" placeholder="Full Name"
									class="form-control" />
								<form:errors class="error-text"  path="name" />
							</div>
							<div class="col">
								<form:input path="email" placeholder="Email"
									class="form-control" />
								<form:errors class="error-text"  path="email" />
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:input path="phone" placeholder="Mobile Number"
									class="form-control" />
								<form:errors class="error-text"  path="phone" />
							</div>
							<div class="col">
								<form:textarea path="address" placeholder="Address"
									class="form-control" />
								<form:errors class="error-text"  path="address" />
							</div>
						</div>
						
						<div class="row">
							<div class="col">
								<form:password path="password" placeholder="Password"
									class="form-control" />
								<form:errors class="error-text"  path="password" />
							</div>
						</div>
						<%-- <div class="row">
							<div class="col">
								<form:password path="confirmPassword"
									placeholder="Confirm Password" class="form-control" />
								<form:errors class="error-text"  path="confirmPassword" />
							</div>
						</div> --%>
						<div class="row">
							<div class="col">
								<input type="submit" value="Register"
									class="form-control btn btn-primary" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file="footer.jsp"%>
