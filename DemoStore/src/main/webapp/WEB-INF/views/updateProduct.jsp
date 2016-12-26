<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Update Product</title>
</head>
<body>
	<%@include file="sidebar.jspf"%>
	<%@include file="navbar.jspf"%>
	<div class="container theme-showcase" role="main">
		<div class="col-md-6 col-md-offset-3">
			<div class="jumbotron">
				<h1>產品管理系統</h1>
				<p class="lead">本系統為輔仁大學資訊管理學系之範例程式</p>
			</div>
			<div class="container">
				<div class="row">
					<br>

					<div class="input-group">
						<form method="post" action="updateProduct" id="updateForm">
							<input type="hidden" name="id" value="${product.id}">
							<div class="form-group">
								<label>供應商編號:</label>
								<input type="text" name="supplierid" placeholder="輸入供應商編號" value="${product.supplierid }" required>
							</div>
							<div class="form-group">
								<label>產品名稱:</label>
								<input type="text" name="name" placeholder="輸入產品名稱" value="${product.name }" required>
							</div>
							<div class="form-group">
								<label for="category">類別:</label> <select class="form-control"
									name="category">
									<option value="man" ${product.category==man?'selected':''}>男裝</option>
									<option value="woman" ${product.category==woman?'selected':''}>女裝</option>
								</select>
							</div>
							<div class="form-group">
								<label for="size">尺寸:</label> <select class="form-control"
									name="size">
									<option value="XS" ${product.size==XS?'selected':''}>XS</option>
									<option value="S" ${product.size==S?'selected':''}>S</option>
									<option value="M" ${product.size==M?'selected':''}>M</option>
									<option value="L" ${product.size==L?'selected':''}>L</option>
									<option value="XL" ${product.size==XL?'selected':''}>XL</option>
								</select>
							</div>
							<div class="form-group">
								<label for="color">顏色:</label> <select class="form-control"
									name="color">
									<option value="Red" ${product.color==Red?'selected':''}>紅</option>
									<option value="Black" ${product.color==Black?'selected':''}>黑</option>
									<option value="Blue" ${product.color==Blue?'selected':''}>藍</option>
									<option value="Green" ${product.color==Green?'selected':''}>綠</option>
									<option value="Yellow" ${product.color==Yellow?'selected':''}>黃</option>
								</select>
							</div>
							<div class="form-group">
								<label>描述:</label> <input  type="text" name="desc"
									placeholder="輸入產品敘述" value="${product.desc}" required>
								<p class="help-block">產品敘述</p>
							</div>
							<div class="form-group">
								<label>產品定價:</label>
								<input type="text" name="price" placeholder="輸入產品定價" value="${product.price }" required>
							</div>
							<div class="form-group">
								<label>庫存量:</label> <input type="number" name="inventory"
									placeholder="0" value="${product.inventory}" required>
								<p class="help-block">目前庫存數量</p>
							</div>
							<div class="form-group">
								<label>安全存量:</label> <input type="number" name="reorderPoint"
									placeholder="0" value="${product.reorderPoint}" required>
								<p class="help-block">當目前庫存數量低於此數字就應該進貨</p>
							</div>
							<button type="submit" class="btn btn-primary">修改</button>
						</form>
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
	<script src="<c:url value="/resources/js/jquery.validate.js" />"></script>
	<script src="<c:url value="/resources/js/jsadditional-methods.js" />"></script>
	<script src="<c:url value="/resources/js/messages_zh_TW.js" />"></script>
	<script>
		$("#updateForm").validate();
	</script>
</body>
</html>