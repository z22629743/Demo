<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 最新編譯和最佳化的 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- 選擇性佈景主題 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- 最新編譯和最佳化的 JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<div id="page-wrapper">

	<div class="container-fluid">

		<!-- Page Heading -->
		<div class="row"></div>
		<!-- /.row -->

		<div class="row">
			<div class="col-lg-12">
				<div class="alert alert-info alert-dismissable">
					<form action="login" method="post" role="form">
						<div class="form-group">
							<title>產品管理</title>
</head>
<body>
	<%-- <%@include file="navbar.jspf" %> --%>

	<div class="container theme-showcase" role="main">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="jumbotron">
					<div style="margin: 0 auto; border: 2px; width: 150px;">
						<h1>pipi (◕ᴥ◕)ﾉ</h1>
						<p class="lead">管理者請登入</p>
					</div>

					<div class="row">

						<form action="login" method="post" role="form">
							<div style="text-align: center;"></div>
							<div style="margin: 0 auto; border: 2px; width: 150px;">
								<div class="form-group">

									<label>帳號:</label>
									<!-- <input type="text" name="username"> -->
									<input type="text" name="username" class="form-control "
										placeholder="管理者帳號" required="" autofocus="">
									<!-- <p class="help-block">使用者帳號</p> -->
								</div>
							</div>
							<div style="margin: 0 auto; border: 2px; width: 150px;">
								<div class="form-group">
									<label>密碼:</label>
									<!-- <input type="password" name="password"> -->
									<input type="text" name="password" class="form-control"
										placeholder="管理者密碼" required="" autofocus="">
									<!-- <p class="help-block">使用者密碼</p> -->

								</div>
								<button type="submit" class="btn btn-primary btn-md">
									登入<span class="glyphicon glyphicon-log-in"></span>
								</button>
						</form>

						<!-- <a href="newuser">註冊</a> -->

						<button type="button" class="btn btn-info btn-md"
							data-toggle="modal" data-target="#myModal">註冊新會員</button>

						<label class="label label-warning">${message}${newaccount.name}</label>
						
				</div>
					

					<!-- ============================================================================================================ -->
					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Modal title</h4>
								</div>
								<div class="modal-body">
									<h1></h1>
									<P>註冊</P>
									<form action="newuser" method="post">
										帳號:<input type="text" name="account" /></br> 密碼:<input
											type="password" name="password" /></br> 姓名:<input type="text"
											name="name" /></br> 電話:<input type="text" name="phone" /></br> 地址:<input
											type="text" name="address" /></br> Email:<input type="text"
											name="email" /></br>
										<div class="form-group">
											職位:<select class="form-control" name="position">
												<option value="Warehouse staff">Warehouse staff</option>
												<option value="Purchasing staff">Purchasing staff</option>
												<option value="Accounting staff">Accounting staff</option>
												<option value="Salesperson">Salesperson</option>
												<option></option>
											</select>
										</div>
										<button type="submit" class="btn btn-danger">註冊</button>

									</form>


								</div>
		
							</div>
						</div>



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


</body>
</html>