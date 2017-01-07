<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/simple-sidebar.css" />" rel="stylesheet">
    <title>產品管理</title>
</head>
<body>
<%@include file="sidebar.jspf" %>
	<%@include file="navbar.jspf" %>
    <div class="container theme-showcase" role="main" >
    
      <div class="jumbotron" style="margin-left: 8cm;">    
        <h1>${customer.name }的訂單</h1>
        <p class="lead">本系統為輔仁大學資訊管理學系之範例程式</p>
        <label class="label label-warning">${message}</label>
      </div>
	<div class="container" style="margin-left: 4cm;">
		<form action="see2" style="margin-left: 1cm;">
					<input type="text" name="name" placeholder="請輸入產品名稱">
					<input type="hidden" name="id" value="${customer.id }">
					<button type="submit" class="glyphicon glyphicon-search">查詢</button>
				</form>
		<div class="row" style="margin-left: 0.5cm;">
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
				  		<th>庫存量</th>
				  		<th>數量</th>
				  		<th>動作</th>
				  	</tr>
				  	<c:forEach items="${productList}" var="product">
				  	<form class="modal-content animate" action="addShoppingCart" method = GET>
  <input type="hidden" name="id" value="${product.id }">
  <input type="hidden" name="customerid" value="${customer.id }">
					  	<tr>
					  		<td>${product.id}</td>
					  		<td>${product.name }</td>
					  		<td>${product.category}</td>
					  		<td>${product.size }</td>
					  		<td>${product.color }</td>
					  		<td>${product.price}</td>
					  		<td>${product.inventory}</td>
					  		<td><input type="text" placeholder="輸入數量" name ="quantity"  required></td>
					  		<td>
					  		<button type="submit"  >加入訂單</button>
					  		</td>
					  	</tr>
					  	</form>
				  	</c:forEach>
				</table>
			</div>
		</div>
	</div>

    </div><!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>
