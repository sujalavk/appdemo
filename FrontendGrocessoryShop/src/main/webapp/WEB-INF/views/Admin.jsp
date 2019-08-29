

<%@include file="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <!-- It can be fixed with bootstrap affix http://getbootstrap.com/javascript/#affix-->
            <div id="sidebar" class="well sidebar-nav">
                <h5><i class="glyphicon glyphicon-home"></i>
                    <small><b>MANAGEMENT</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">
                 
                    <li class="active"><a href=" <c:url value="productlist"/>"> Product</a></li>
                    <li><a href=" <c:url value="category"/>">Category</a></li>
                </ul>
                
        <div class="col-md-8">
            <!-- Content Here -->
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>


<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Add</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	font-family: Arial;
}

/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border-top: none;
}
</style>
</head>
<body>
	<script>
		function openTab(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}
	</script>
	<div class="header">
  <%@include file="header.jsp" %>
</div>
	<div class="container">
		<h2>Admin</h2>

		<div class="tab">
			<button class="tablinks" onclick="openTab(event, 'Product')">Product</button>
			<button class="tablinks" onclick="openTab(event, 'Category')">Category</button>
			<button class="tablinks" onclick="openTab(event, 'Supplier')">Supplier</button>

		</div>

		<div class="tab-content">
			<div id="Product" class="tabcontent">
				<h3>Product</h3>
				<%@include file="ProductList.jsp"%>
			</div>
			<div id="Category" class="tabcontent">
				<h3>Category</h3>
				<%@include file="category.jsp"%>
			</div>
			<div id="Supplier" class="tabcontent">



				<%@include file="supplier.jsp"%>
			</div>

		</div>
	</div>

</body>
</html> --%>