<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
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
	<title>Update Product</title>
</head>
<body>
	 <%@include file="sidebar.jspf" %>
     <%@include file="navbar.jspf" %>
	<div class="container theme-showcase" role="main" style="margin-left: 235px">
    
      <div class="jumbotron" >    
        <h1>產品管理系統</h1>
        <p class="lead">本系統為輔仁大學資訊管理學系之範例程式</p>
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="post" action="updateCustomer" id="updateForm">
					<input type="hidden" name="id" value="${customer.id}">
<!-- will need this part later
				  	<div class="form-group">
					    <label for="articleCategory.id">分類</label>
				  		<select class="form-control" id="articleCategory.id" name="articleCategory.id">
				  		<c:forEach items="${articleCategoryList}" var="articleCategory">
					  		<option value="${articleCategory.id}" ${article.articleCategory.id==articleCategory.id?'selected':''}>
					  			${articleCategory.name}
				  			</option>
				  		</c:forEach>
						</select>
				  	</div>
-->

					<div class="form-group">
						<label>姓名:</label>
						<input type="text" name="name" placeholder="輸入姓名" value="${customer.name}" required>
						
					</div>
					<div class="form-group">
						<label>電話:</label>
						<input type="number" name="phone" placeholder="請輸入聯絡方式" value="${customer.phone}" required>
						
					</div>
					<div class="form-group">
						<label>地址:</label>
						<input type="number" name="address" placeholder="請輸入地址" value="${customer.address}" required>
						<p class="help-block">貨達目的地</p>
					</div>
					<div class="form-group">
						<label for="level">客戶層級:</label>
						<select class="form-control" name="level">
						<option value="A" ${customer.level==A?'selected':''}>A</option>
						<option value="B" ${customer.level==B?'selected':''}>B</option>
						<option value="C" ${customer.level==C?'selected':''}>C</option>
						<option value="D" ${customer.level==D?'selected':''}>D</option>
						<option value="E" ${customer.level==E?'selected':''}>E</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">修改</button>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	</div><!-- /.container -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/jquery.validate.js" />"></script>
    <script src="<c:url value="/resources/js/jsadditional-methods.js" />"></script>
    <script src="<c:url value="/resources/js/messages_zh_TW.js" />"></script>
	<script>
	$("#updateForm").validate();
	</script>
</body>
</html>