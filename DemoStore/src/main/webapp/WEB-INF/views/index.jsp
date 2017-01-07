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

						<label class="label label-warning">${message}${newaccount.name}</label>
						
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