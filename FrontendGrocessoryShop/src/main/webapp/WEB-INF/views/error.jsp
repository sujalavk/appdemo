<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error</title>
</head>
<body>
<body>

	<div class="header">
		<%@include file="header.jsp"%>
	</div>


	<div class="content">

		<div class="container">

			<div class="row">

				<div class="col-xs-12">


					<div class="jumbotron">

						<h1>${errorTitle}</h1>
						<hr />

						<blockquote style="word-wrap: break-word">

							${errorDescription}</blockquote>

					</div>


				</div>

			</div>

		</div>

	</div>
	<div class="footer">
		<%@include file="footer.jsp"%>
	</div>




</body>
</body>
</html>