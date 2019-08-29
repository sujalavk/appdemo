<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
	<c:url var="addAction"  value="/productAdd"></c:url>
	<c:if test="${not empty msg}">



		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-info fade in">${msg}</div>
			</div>
		</div>
	</c:if>
	<form:form action="${addAction}" enctype="multipart/form-data" commandName="product"  role="form">

		<table class="table table-condensed">
<%-- <tr>	
		<td><form:label path="pid">	<spring:message text="Product Id" /></form:label></td> 
			<c:choose>
				<c:when test="${!empty product.pid}">

					<td><form:input path="pid" disabled="true" readonly="true" /></td>
				</c:when>
				<c:otherwise>
					<td><form:input path="pid" required="true" disabled="true" /></td>
				</c:otherwise>
			</c:choose>
			</tr> --%>
			<tr>
				<form:input path="pid" hidden="true" />




				<%-- 
		<td>	<form:label path="pid"><spring:message text="Product Id" /> </form:label></td>
		<td>	<form:input id="product_id" path="pid" type="text" hidden="true" disabled ="true" /></td> --%>


			</tr>
			<tr>
				<td><form:label path="pname">
						<spring:message text="ProductName" />
					</form:label></td>
				<td><form:input id="product_name" path="pname" type="text"
						placeholder="Product Name" required="true" /></td>
			</tr>
			<tr>



				<td><form:label path="description">
						<spring:message text="Product Description" />
					</form:label></td>
				<td><form:input path="description"
						placeholder="Product Description" required="true" type="text" /></td>
			</tr>

			<tr>
				<td><form:label path="price">
						<spring:message text="Product Price" />
					</form:label></td>

				<td><form:input id="product_price" path="price"
						placeholder="Product Price" required="true" type="text" /></td>
			</tr>


			<tr>

				<td><form:label path="stock">
						<spring:message text=" Product Quantity" />
					</form:label></td>

				<td><form:input id="product_stock" path="stock"
						placeholder="Product Stock" required="true" type="text" /></td>
			</tr>

			<tr>
				<td><form:label path="category_id">
						<spring:message text="Produt Category" />
					</form:label></td>
				<td><form:select path="category_id">
						<c:forEach var="category" items="${categoryList}">
							<option>${category.cname}</option>
						</c:forEach>
					</form:select></td>
			</tr>

			<tr>
				<td><form:label path="supplier_id">
						<spring:message text="Product 	Supplier" />
					</form:label></td>

				<td><form:select class="form-control" path="supplier_id">
						<c:forEach var="supplier" items="${supplierList}">
							<option>${supplier.supplierName}</option>
						</c:forEach>
					</form:select></td>
			</tr>






			<tr>
				<td><from:label>
						<spring:message text="Product image" />
					</from:label></td>

				<td><input id="file" name="file" class="input-file" type="file"></td>
			<tr>
				<td><input type="submit" path="submit" class="btn btn-primary"
					value="<spring:message text="Submit"/>" /></td>



				<td><input type="submit" path="cancel" class="btn btn-warning"
					value="<spring:message text="Cancel"/>" /></td>
			</tr>

		</table>
	</form:form>




</body>

</html>