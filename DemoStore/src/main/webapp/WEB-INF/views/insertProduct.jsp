<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        
    
	<title>Insert Product</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
	<div class="container theme-showcase" role="main">
    
      <div class="jumbotron" >    
        <h1>產品管理系統</h1>
        <p class="lead">本系統為輔仁大學資訊管理學系之範例程式</p>
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="post" action="insertProduct" id="insertForm">
				<div class="form-group">
						<label>供應商編號:</label>
						<input type="text" name="supplierid" placeholder="輸入供應商編號" required>
					</div>
					<div class="form-group">
						<label>產品名稱:</label>
						<input type="text" name="name" placeholder="輸入產品名稱" required>
					</div>
					<div class="form-group">
						類別:<select class="form-control" name="category">
  						<option value="man">男裝</option>
  						<option value="woman">女裝</option>
						</select>
					</div>
					<div class="form-group">
						尺寸:<select class="form-control" name="size">
  						<option value="XS">XS</option>
  						<option value="S">S</option>
  						<option value="M">M</option>
  						<option value="L">L</option>
  						<option value="XL">XL</option>
						</select>
					</div>
					<div class="form-group">
						顏色:<select class="form-control" name="color">
  						<option value="Red">紅</option>
  						<option value="Black">黑</option>
  						<option value="Blue">藍</option>
  						<option value="Green">綠</option>
  						<option value="Yellow">黃</option>
						</select>
					</div>
					<div class="form-group">
						<label>描述:</label>
						<input type="text" name="desc" placeholder="輸入產品敘述" required>
						<p class="help-block">產品敘述</p>
					</div>
					<div class="form-group">
						<label>定價:</label>
						<input type="text" name="price" placeholder="輸入產品金額" required>
					</div>
					<div class="form-group">
						<label>庫存量:</label>
						<input type="number" name="inventory" placeholder="0" required>
						<p class="help-block">目前庫存數量</p>
					</div>
					<div class="form-group">
						<label>安全存量:</label>
						<input type="number" name="reorderPoint" placeholder="0" required>
						<p class="help-block">當目前庫存數量低於此數字就應該進貨</p>
					</div>
			  		<button type="submit" class="btn btn-default">新增</button>
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
	$("#insertForm").validate();
	</script>
</body>
</html>