<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
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
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" style="margin-left: 8cm;">    
        <h1>產品管理系統</h1>
        <p class="lead">本系統為輔仁大學資訊管理學系之範例程式</p>
      </div>
	<div class="container"style="margin-left: 5cm;">
		<div class="row">
			<br>
			<div class="col-md-12">
				<table class="table">
				  	<tr>
				  		<th>編號</th>
				  		<th>客戶名稱</th>
				  		<th>客戶地址</th>
				  		<th>客戶電話</th>
				  		<th>銷貨單成立時間</th>
				  		<th>出貨單成立時間</th>
				  		<th>到款時間</th>
				  		<th>管理</th>
				  	</tr>
				  	<c:forEach items="${saList}" var="sa">
					  	<tr>
					  		<td>${sa.soid}</td>
					  		<td>${sa.customername}</td>
					  		<td>${sa.customeraddress}</td>
					  		<td>${sa.customerphone}</td>
					  		<td>${sa.ordertime}</td>
					  		<td>${sa.shippingtime}</td>
					  		<td>
					  			<c:choose>
					  				<c:when test="${empty sa.ar_time}">
										<a class="btn btn-default" href="arrive?id=${sa.soid}">總額${sa.orderprice }到款</a>
    								</c:when>
    								<c:otherwise>
        								${sa.ar_time}
    								</c:otherwise>
								</c:choose>				  							  			
					  		</td>
					  		<td><a class="btn btn-default" href="deleteList?id=${sa.soid}" Method="GET">刪除</a></td>
					  	</tr>
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
