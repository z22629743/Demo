<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
    <title>產品管理</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" >    
        <h1>出貨單</h1>
        <p class="lead">本系統為輔仁大學資訊管理學系之範例程式</p>
      </div>
      

      
	<div class="container">
	 <form action="see2">
      <input type="text" name="customerID" placeholder="請輸入客戶編號">
      <button type="submit" class="glyphicon glyphicon-search">查詢</button>
      </form>
		<div class="row">
			<br>
			<div class="col-md-12">
				<table class="table">
				  	<tr>
				  		<th>產品編號  </th><th>類別</th><th>描述</th><th>數量</th><th>動作</th><th>出貨時間</th>
				  	</tr>
				  	<c:forEach items="${shoppingCart}" var="po">
					  	<tr>
					  		<td>${po.id}</td>
					  		<td>${po.category}</td>
					  		<td>${po.desc}</td>
					  		<td>${po.quantity }</td>
					  		<td><a class="btn btn-default" href="deleteSC?id=${po.id}" Method="GET">刪除</a>
					  		<a class="btn btn-default" href="deleteSC?id=${po.id}" Method="GET">出貨</a>
					  		</td>
                   		    <td>${po.shippingtime}</td> 
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