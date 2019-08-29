
<html>
<head>

<title>Welcome to Grocessory Shopping</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.carousel-inner img {
	width: 331px;
	height:152px;
}
</style>
</head>
<body class="bg-light">
<div class="container">
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${pageContext.request.contextPath}/resources/images/img1.jpg" alt="Dry fruits" >
      </div>

      <div class="item">
        <img src="${pageContext.request.contextPath}/resources/images/img2.jpg" alt="Fruits">
      </div>
    
      <div class="item">
        <img src="${pageContext.request.contextPath}/resources/images/img3.jpg" alt="Vegetables">
      </div>
       <div class="item">
        <img src="${pageContext.request.contextPath}/resources/images/FRESH.jpg" alt="Shopping"">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<%-- 
	<div class="container-fluid" id="body-container">
		<div id="carousel-container" class="carousel slide"
			data-ride="carousel">
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
				<li data-target="#demo" data-slide-to="3"></li>
			</ul>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="${pageContext.request.contextPath}/resources/images/img1.jpg"
						alt="img1">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/images/img2.jpg"
						alt="img2">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/images/img3.jpg"
						alt="img3">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/images/img4.jpg"
						alt="img4">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carousel-container"
				data-slide="prev"> <span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#carousel-container"
				data-slide="next"> <span class="carousel-control-next-icon"></span>
			</a>
		</div>
	</div> --%>
</body>
</html>
