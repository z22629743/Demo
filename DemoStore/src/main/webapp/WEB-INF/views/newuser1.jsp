<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<!-- 最新編譯和最佳化的 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">


<!-- 選擇性佈景主題 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- 最新編譯和最佳化的 JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</head>

<body>
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
						帳號:<input type="text" name="account" /></br> 密碼:<input type="password"
							name="password" /></br> 姓名:<input type="text" name="name" /></br> 電話:<input
							type="text" name="phone" /></br> 地址:<input type="text" name="address" /></br>
						Email:<input type="text" name="email" /></br>
						<div class="form-group">
							職位:<select class="form-control" name="position">
								<option value="Warehouse staff">Warehouse staff</option>
								<option value="Purchasing staff">Purchasing staff</option>
								<option value="Accounting staff">Accounting staff</option>
								<option value="Salesperson">Salesperson</option>
								<option></option>
							</select>
						</div>
						<button type="submit" class="btn btn-danger">登入</button>

					</form>



				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>



	</div>



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script>
		$(function() {
			$(".deleteBtn").click(function() {
				//alert($(this).attr("data-id"));
				$("#deleteID").val($(this).attr("data-id"));
			});
		});
	</script>
</body>

<!-- <script src="/resources/js/newuser.js" type="text/javascript"></script> -->

</html>

<!-- ====================================================================== -->



<!-- END # BOOTSNIP INFO -->

<!-- BEGIN # MODAL LOGIN -->

<!--<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" align="center">
				<img class="img-circle" id="img_logo"
					src="http://bootsnipp.com/img/logo.jpg">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
				</button>
			</div>

			
			<div id="div-forms">

				
				<form id="login-form">
					<div class="modal-body">
						<div id="div-login-msg">
							<div id="icon-login-msg"
								class="glyphicon glyphicon-chevron-right"></div>
							<span id="text-login-msg">Type your username and password.</span>
						</div>
						<input id="login_username" class="form-control" type="text"
							placeholder="Username (type ERROR for error effect)" required>
						<input id="login_password" class="form-control" type="password"
							placeholder="Password" required>
						<div class="checkbox">
							<label> <input type="checkbox"> Remember me
							</label>
						</div>
					</div>
					<div class="modal-footer">
						<div>
							<button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
						</div>
						<div>
							<button id="login_lost_btn" type="button" class="btn btn-link">Lost
								Password?</button>
							<button id="login_register_btn" type="button"
								class="btn btn-link">Register</button>
						</div>
					</div>
				</form>
				

				
				<form id="lost-form" style="display: none;">
					<div class="modal-body">
						<div id="div-lost-msg">
							<div id="icon-lost-msg" class="glyphicon glyphicon-chevron-right"></div>
							<span id="text-lost-msg">Type your e-mail.</span>
						</div>
						<input id="lost_email" class="form-control" type="text"
							placeholder="E-Mail (type ERROR for error effect)" required>
					</div>
					<div class="modal-footer">
						<div>
							<button type="submit" class="btn btn-primary btn-lg btn-block">Send</button>
						</div>
						<div>
							<button id="lost_login_btn" type="button" class="btn btn-link">Log
								In</button>
							<button id="lost_register_btn" type="button" class="btn btn-link">Register</button>
						</div>
					</div>
				</form>
				

				
				<form id="register-form" style="display: none;">
					<div class="modal-body">
						<div id="div-register-msg">
							<div id="icon-register-msg"
								class="glyphicon glyphicon-chevron-right"></div>
							<span id="text-register-msg">Register an account.</span>
						</div>
						<input id="register_username" class="form-control" type="text"
							placeholder="Username (type ERROR for error effect)" required>
						<input id="register_email" class="form-control" type="text"
							placeholder="E-Mail" required> <input
							id="register_password" class="form-control" type="password"
							placeholder="Password" required>
					</div>
					<div class="modal-footer">
						<div>
							<button type="submit" class="btn btn-primary btn-lg btn-block">Register</button>
						</div>
						<div>
							<button id="register_login_btn" type="button"
								class="btn btn-link">Log In</button>
							<button id="register_lost_btn" type="button" class="btn btn-link">Lost
								Password?</button>
						</div>
					</div>
				</form>  -->
<!-- End | Register Form -->