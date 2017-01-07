<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<!-- Bootstrap Core CSS -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Custom CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/simple-sidebar.css" />"
	rel="stylesheet">


<title>產品管理</title>
</head>
<body>
	<%@include file="sidebar.jspf"%>
	<%@include file="navbar.jspf"%>

    <div class="container theme-showcase" role="main">
    
     <div class="jumbotron" style="margin-left: 8cm;"> 
			<h1>產品管理系統</h1>
			<p class="lead"></p>
		</div>
		<div class="container">
			<div class="row">
				<br>
					<div class="col-md-9 col-md-offset-3">
					<button type="button" class="btn btn-info btn-md"
							data-toggle="modal" data-target="#myModal">註冊新會員</button>
					<table class="table">
						<tr>
							<th>編號</th>
							<th>名稱</th>
							<th>電話</th>
							<th>地址</th>
							<th>Email</th>
							<th>帳號</th>
							<th>密碼</th>
							<th>職位</th>
							<th>編輯</th>
						</tr>
						<c:forEach items="${managerList}" var="manager">
							<tr>
								<td>${manager.id}</td>
								<td>${manager.name }</td>
								<td>${manager.phone }</td>
								<td>${manager.address}</td>
								<td>${manager.email }</td>
								<td>${manager.account }</td>
								<td>${manager.password}</td>
								<td>${manager.position }</td>
								<td> <a
									class="btn btn-sm btn-danger deleteBtn" href="#"
									data-toggle="modal" data-target="#deleteModal"
									data-id="${manager.id}">刪除</a></td>
									
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="modal fade bs-example-modal-sm" id="deleteModal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">刪除</h4>
					</div>
					<div class="modal-body">
						<p>確認刪除後，相關之訊息也將刪除</p>
					</div>
					<div class="modal-footer">
						<form id="deleteForm" action="deleteManager" method="post">
							<input type="hidden" name="id" id="deleteID">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-danger">確認刪除</button>
						</form>
					</div>
				</div>
			</div>
		</div>


	</div>
	<!-- /.container -->
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
												<option value="Manager">Manager</option>
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
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
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