<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
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
			<h1>客戶管理系統</h1>
			<p class="lead">請選擇功能</p>
		</div>
		<div class="container">
			<div class="row">
				<br>
				<div class="col-md-9 col-md-offset-3">
					<a class="btn btn-primary" href="insertCustomer">新增</a>
					<table class="table">
						<tr>
							<th>編號</th>
							<th>姓名</th>
							<th>電話</th>
							<th>地址</th>
							<th>客戶層級</th>
							<th>編輯</th>
						</tr>
						<c:forEach items="${customerList}" var="c">
							<tr>
								<td>${c.id}</td>
								<td>${c.name}</td>
								<td>${c.phone}</td>
								<td>${c.address}</td>
								<td>${c.level}</td>
								<td><a class="btn btn-default"
									href="updateCustomer?id=${c.id}">修改</a> <a
									class="btn btn-sm btn-danger deleteBtn" href="#"
									data-toggle="modal" data-target="#deleteModal"
									data-id="${c.id}">刪除</a></td>
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
						<form id="deleteForm" action="deleteCustomer" method="post">
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