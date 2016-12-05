<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>


<html>

<head>
<!meta http-equiv="content-type" content="text/html; charset="UTF-8"/>
<link rel='stylesheet' href='/css/bootstrap.min.css' type='text/css'
	media='all' />
<link href="/css/main.css" rel="stylesheet">

</head>
<body>

	<div id="header">
		<p class='headerclass'>
			<h3>Simplesite 
				<a class="btn btn-info active pull-right" href='${contextPath}/catalog'>Catalog</a>
				<a class="btn btn-info active pull-right" href='${contextPath}/about'>About</a> 
				<a class="btn btn-info active pull-right" href='${contextPath}/'>Home</a>
			</h3>	
		</p>
		<br>

	</div>

	<div class="page-main-content">
		
		<div class="page-description-bg">
			<div class="page-description">${pageDescription}</div>
		</div>

		<div class="page-content">
			<br>
		</div>
		
	</div>
	
</body>

<footer> &#169; 2016 Company, Inc. </footer>

</html>