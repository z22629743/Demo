<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/simple-sidebar.css" />"
	rel="stylesheet">

<title>產品管理</title>
</head>
<body>
	<%@include file="sidebar.jspf"%>
	<%@include file="navbar.jspf"%>
	<div class="container theme-showcase" role="main">

		<div class="jumbotron" style="margin-left: 8cm;">
			<h1>建立訂單</h1>
			<p class="lead">請選擇功能</p>
		</div>
		<div class="container" >
			<div class="col-md-9 col-md-offset-3">
				<div class="row">
					<br>
					<div class="col-md-12">
						<table class="table">
							<tr>
								<th>編號</th>
								<th>姓名</th>
								<th>電話</th>
								<th>地址</th>
								<th>客戶層級</th>
								<th>編輯</th>
							</tr>
							<c:forEach items="${customerList}" var="customer">
								<tr>
									<td>${customer.id}</td>
									<td>${customer.name}</td>
									<td>${customer.phone}</td>
									<td>${customer.address}</td>
									<td>${customer.level}</td>
									<td><a class="btn btn-default"
										href="availableProduct?id=${customer.id}">選擇</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>


	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>


</body>
</html>