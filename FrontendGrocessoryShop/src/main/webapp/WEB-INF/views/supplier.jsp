<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Supplier</title>
</head>
<body>

		<div class="container">

			<c:if test="${not empty msg}">
				<div class="row">
					<div class="col-xs-12 col-md-offset-2 col-md-8">
						<div class="alert alert-info fade in">${msg}</div>
					</div>
				</div>
			</c:if>

			<div class="row">

				<div class="col-md-offset-2 col-md-8">

					<div class="panel panel-default">

						<div class="panel-heading">

							<h4>Supplier Details</h4>

						</div>
<sf:form class="form-horizontal" modelAttribute="supplier" action="${contextRoot}/supplier" method="post">

						<div class="panel-body">

							<div class="form-group">
								<label class="control-label col-md-4">Supplier ID</label>
								<div class="col-md-8">
									<sf:input type="text" path="sid" class="form-control"
										placeholder="Supplier Id" />

								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4">Supplier Name</label>
								<div class="col-md-8">
									<sf:input type="text" path="supplierName" class="form-control"
										placeholder="Supplier Name" />

								</div>
							</div>


							<div class="form-group">

								<div class="col-md-offset-4 col-md-4">

									<input type="submit" name="submit" value="Save"
										class="btn btn-primary" />
<sf:hidden path="sid"/>
								</div>
							</div>

						</div>
						</sf:form>
					</div>

				</div>

			</div>
		</div>

		
<
</body>
</html>