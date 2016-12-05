<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="javax.servlet.jsp.*" contentType="text/html; charset=UTF8"%>
<!DOCTYPE html>


<html>

<head>
<!meta http-equiv="content-type" content="text/html; charset="UTF-8"/>
<link rel='stylesheet' href='/css/bootstrap.min.css' type='text/css'
	media='all' />
<link href="/css/main.css" rel="stylesheet">

<title>Интернет магазин</title>

</head>
<body>

	<div id="header">
		<p class='headerclass'>
		<h3>
			Simplesite 
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
			<table class='table table-bordered table-hover'>
				<tr>
					<th width='3%'>#</th>
					<th>Название</th>
					<th>Краткое описание</th>
					<th width='10%'>Стомость за единицу, руб.</th>
					<th>Изображение</th>
					<th width='10%'>Количество на складе, шт.</th>
				</tr>
				<c:set var="i" value="${0 + offset}" scope="page" />

				<c:forEach items="${productsWithPagination}" var="item">
					<tr>
						<c:set var="i" value="${i + 1}" scope="page" />

						<td><c:out value="${i}"></c:out></td>
						<td>${item.getName()}</td>
						<td>${item.getDescription()}</td>
						<td>${item.getPrice()}</td>
						<td><center>
								<img align="middle" src='../images/${item.getImageName()}'
									width='50px' height='50px'></img>
								<center></td>
						<td>${item.getQuantity()}</td>
					</tr>

				</c:forEach>


			</table>

			<ul class="pagination">
				<li><a href="?offset=${offset == 0? 0 : offset-limit}&limit=${limit}">«</a></li>
				<li><a href="?offset=${offset+limit}&limit=${limit}">»</a></li>
			</ul>
			<br>

		</div>
	</div>
</body>

<footer class="page-footer"> &#169; 2016 Company, Inc. </footer>
</html>