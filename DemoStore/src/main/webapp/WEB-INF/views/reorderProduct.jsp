<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>

     	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 

    <!-- Bootstrap Core CSS -->
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!-- Custom CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css.css" rel="stylesheet">
     <link href="<c:url value="/resources/css/simple-sidebar.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap.min.css/" />" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title>產品管理</title>
</head>
<body>
	 <%@include file="sidebar.jspf" %>
 <%@include file="navbar.jspf" %>
    <div class="container theme-showcase" role="main">
    
     <div class="jumbotron" style="margin-left: 8cm;">  
        <h1>產品進貨系統</h1>
        <p class="lead"></p>
      </div>
	<div class="container">
	
		<div class="row">
		<div class="col-md-9 col-md-offset-3">
		<form action="seereorderProduct">
					<input type="text" name="supplierid" placeholder="請輸入供應商編號">
					<button type="submit" class="glyphicon glyphicon-search">查詢</button>
				</form>
			<br>
			
				<table class="table">
				  	<tr>
				  		<th>編號</th>
				  		<th>供應商編號</th>
				  		<th>商品名稱</th>
				  		<th>類別</th>
				  		<th>尺寸</th>
				  		<th>顏色</th>
				  		<th>庫存量</th>
				  		<th>安全存量</th>
				  		<th>進貨數量</th>
				  		<th>動作</th>
				  	</tr>
				  	<c:forEach items="${productList}" var="product">
		 <form class="modal-content animate" action="createPO?id=${product.id}" method = GET>
  <input type="hidden" name="id" value="${product.id }">
					  	<tr>
					  		<td>${product.id}</td>
					  		<td>${product.supplierid }</td>
					  		<td>${product.name }</td>
					  		<td>${product.category}</td>
					  		<td>${product.size}</td>
					  		<td>${product.color }</td>
					  		<td>${product.inventory}</td>
					  		<td>${product.reorderPoint}</td>
					  		<td><input type="text" placeholder="輸入數量" name ="quantity"  required></td>
					  		<td>
					  		<button type="submit"  >進貨</button>
					  		</td>
					  	</tr>
					  		  	</form>
				  	</c:forEach>
				</table>
			</div>
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
