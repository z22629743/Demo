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
    
      <div class="jumbotron"style="margin-left: 8cm;" >    
        <h1>出貨單</h1>
        <p class="lead">本系統為輔仁大學資訊管理學系之範例程式</p>
      </div>
      

      
	<div class="container"style="margin-left: 4cm;">
	 <form action="search">
      <input type="text" name="input" placeholder="請輸入...">
      <div class="form-group">
      搜尋方式:<select class="form-control" name="searchmethod">
      			<option value="soid">訂單編號</option>
      			<option value="customername">客戶姓名</option>     
      
      </select>
      </div>
      <button type="submit" class="glyphicon glyphicon-search">查詢</button>
      </form>
		<div class="row">
			<br>
			<div class="col-md-12">
				<table class="table">
				  	<tr>
				  		<th>出貨單編號  </th><th>客戶姓名</th><th>客戶地址</th><th>客戶電話</th><th>出貨單成立時間</th><th>出貨時間</th>
				  	</tr>
				  	<c:forEach items="${List}" var="po">
					  	<tr>
					  		<td>${po.soid}</td>
					  		<td>${po.customername}</td>
					  		<td>${po.customeraddress}</td>
					  		<td>${po.customerphone }</td>
					  		<td>${po.ordertime }</td>
					  		<td>
					  		<c:choose>
					  				<c:when test="${empty po.shippingtime}">
										<a class="btn btn-default" href="saleout?id=${po.soid}">出貨</a>
    								</c:when>
    								<c:otherwise>
        								${po.shippingtime}
    								</c:otherwise>
								</c:choose>	
								</td>
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
