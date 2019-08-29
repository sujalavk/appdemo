 <%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Category</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>

	<div class="container">

<c:if test="${deleteError==true}">
			<div class="alert alert-warning alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Delete Error!</strong> 1 or more products fall under this
				category. Please delete all the products that fall under this
				category and try again.
			</div>
		</c:if>

		<c:url var="addAction"  value="/categoryAdd"></c:url>
		
	
		
		<form:form action="${addAction}" modelAttribute="category" role="form">
			<table class="table table-condensed">
				<tr>
					<td><form:label path="cid">	<spring:message text="Category ID" /></form:label></td>
					<c:choose>
						<c:when test="${!empty category.cid }">
							<td><form:input path="cid" disabled="true" readonly="true" /></td>
						</c:when>
						<c:otherwise>
							<td><form:input path="cid" required="true"
									title="id should be between 4 to 7 characters" /></td>
						</c:otherwise>
					</c:choose>
				</tr>

				<tr>
					<form:input path="cid" hidden="true" />

					
					<td><form:label path="cname">	<spring:message text="Category Name" />	</form:label></td>
					<td><form:input type="text" id="cname"	placeholder="Enter Category Name" path="cname" required="true" />
					</td>
				</tr>

				<tr>
					<td><input type="submit" class="btn btn-primary"
						value="<spring:message text="Save" />" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div class="container">
		<h2>Category List</h2>
		<c:if test="${!empty categoryList}">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>CategoryID</th>
						<th>Category Name</th>
						<th>Edit</th>
						<th>Delete</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categoryList}" var="category">
						<tr>
							<td>${category.cid}</td>
							<td>${category.cname}</td>

							<td> <a href="<c:url value='/categoryEdit/${category.cid}'/>"> <button class="btn btn-warning" style="font-size:20px"><i class="fa fa-edit" style="font-size: 36px"></i> </button></a> 			
									</td>
							<td><a href="<c:url value='/categoryDelete/${category.cid}'/>"> <button class="btn btn-danger" style="font-size:20px"><i class="fa fa-trash-o" style="font-size: 36px"></i></button></a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</c:if>
	</div>





</body>
</html>
