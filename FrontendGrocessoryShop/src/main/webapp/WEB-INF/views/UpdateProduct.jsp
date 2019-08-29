<%@include file="header.jsp"%>
<html>
<head>
<title>Update Product</title>
</head>
<body class="bg-light">
	<div class="container-fluid" id="body-container">
		<h3>Update Product</h3>
		<form:form action="${pageContext.request.contextPath}/updateProduct"
			modelAttribute="updateProduct">
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label>Product Id</label>
						<form:input path="pid" value="${pid}" readonly="true"
							class="form-control" />
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label>Supplier Id</label>
						<form:input path="supplier_id" value="${supplier_id}"
							readonly="true" class="form-control" />
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label>Category Id</label>
						<form:input path="category_id" value="${category_id}"
							readonly="true" class="form-control" />
					
						
					</div>
				</div>
			</div>
			<div class="form-group">
				<label>Product Name</label>
				<form:input path="pname" value="${pname}"
					class="form-control" />
				<form:errors class="error-text" path="pname" />
			</div>
			<div class="form-group">
				<label>Product Description</label>
				<form:textarea path="description" value="${description}"
					class="form-control" />
				<form:errors class="error-text" path="description" />
			</div>
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label>Price</label>
						<form:input type="number" path="price" value="${price}"
							class="form-control" />
						<form:errors class="error-text" path="price" />
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label>Stock</label>
						<form:input type="number" path="stock" value="${stock}"
							class="form-control" />
						<form:errors class="error-text" path="stock" />
					</div>
				</div>
			</div>
			<input id="btn-updateProduct" type="submit" value="Update Product"
				class="form-control btn btn-success" />
		</form:form>
	</div>
</body>
</html>
<%@include file="footer.jsp"%>