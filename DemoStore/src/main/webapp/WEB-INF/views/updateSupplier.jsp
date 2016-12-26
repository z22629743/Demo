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
						<form method="post" action="updateSupplier" id="updateForm">
							<input type="hidden" name="supplierid" value="${supplier.supplierid}">
							<div class="form-group">
								<label>供應商名稱:</label>
								<input type="text" name="name" placeholder="輸入供應商名稱" value="${supplier.name}" required>
							</div>
							<div class="form-group">
								<label>供應商電話:</label>
								<input type="text" name="phone" placeholder="輸入供應商電話" value="${supplier.phone }" required>
							</div>
							<div class="form-group">
								<label>供應商地址:</label>
								<input type="text" name="address" placeholder="輸入供應商地址" value="${supplier.address }" required>
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