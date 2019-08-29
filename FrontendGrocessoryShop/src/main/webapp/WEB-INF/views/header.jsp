<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${contextRoot}/resources/css/styles.css">

</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">Smart Shopping</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">

			<ul class="nav navbar-nav">
				<li class="active"><a href="${contextRoot}/home">Home</a></li>
				<li><select class="form-control">
						<c:forEach var="category" items="${categoryList}">
							<option>${category.cname}</option>
						</c:forEach>
				</select></li>
				<security:authorize access="hasRole('ADMIN')">
					<li><a href="${contextRoot}/Admin">Manage</a></li>
					<li><a href="${contextRoot}/showOrders">Show Orders</a></li>
				</security:authorize>
				<security:authorize access="hasRole('USER')">
					<li><a href="${contextRoot}/cart/myCart"><span
							class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
					<li><a href="${contextRoot}/productlist"> View Products</a></li>
				</security:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${pageContext.request.userPrincipal.name  == null}">
					<li><a href="${contextRoot}/register"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="${contextRoot}/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
				<security:authorize access="isAuthenticated()">
					<li>Welcome <security:authentication
							property="principal.username" />
					</li>
				</security:authorize>
			<security:authorize access="isAuthenticated()">
					<li><a href="${contextRoot}/logout"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</security:authorize>
			</ul>
		</div>
	</div>
	</nav>



</body>
</html>
