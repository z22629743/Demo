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
<title>銷貨單</title>
</head>
<body>
	<%@include file="sidebar.jspf"%>
	<%@include file="navbar.jspf"%>
	<div class="container theme-showcase" role="main">

		<div class="jumbotron" style="margin-left: 8cm;">
			<h1>銷貨單</h1>
			<p class="lead">請選擇功能</p>
		</div>



		<div class="container" >
			<div class="col-md-9 col-md-offset-3">
				<form action="see">
					<input type="text" name="customerID" placeholder="請輸入客戶編號">
					<button type="submit" class="glyphicon glyphicon-search">查詢</button>
				</form>
				<div class="row">
					<br>
					<div class="col-md-12">
						<table class="table">
							<tr>
								<th>編號</th>
								<th>商品名稱</th>
								<th>類別</th>
								<th>尺寸</th>
								<th>顏色</th>
								<th>價格</th>
				  				<th>數量</th>
								<th>動作</th>
								<th><a class="btn btn-primary"
									href="checkout?id=${customerID }">建立出貨單</a></th>
							</tr>
							<c:forEach items="${shoppingCart}" var="po">
								<tr>
									<td>${po.id}</td>
									<td>${po.name }</td>
									<td>${po.category}</td>
									<td>${po.size }</td>
									<td>${po.color }</td>
									<td>${po.price}</td>
									<td>${po.quantity }</td>
									<td><a class="btn btn-default" href="deleteSC?id=${po.id}&&customerID=${customerID}"
										Method="GET">刪除</a></td>
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
	<script>
    $(function(){
    	$(".deleteBtn").click(function(){
    		//alert($(this).attr("data-id"));
    		$("#deleteID").val($(this).attr("data-id"));
    	});
    });
    </script>


</body>
</html>
