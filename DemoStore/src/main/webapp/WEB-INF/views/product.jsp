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
					<a class="btn btn-primary" href="insertProduct">新增</a>
					<table class="table">
						<tr>
							<th>編號</th>
							<th>供應商編號</th>
							<th>商品名稱</th>
							<th>類別</th>
							<th>圖片</th>
							<th>尺寸</th>
							<th>顏色</th>
							<th>描述</th>
							<th>價格</th>
							<th>庫存量</th>
							<th>安全存量</th>
							<th>編輯</th>
						</tr>
						<c:forEach items="${productList}" var="product">
							<tr>
								<td>${product.id}</td>
								<td>${product.supplierid }</td>
								<td>${product.name }</td>
								<td>${product.category}</td>
								 <td><img src="<%=request.getContextPath()%>/resources/fileUpload/${product.id}.jpg" width="240 px" height="240 px "/></td>
								<td>${product.size }</td>
								<td>${product.color }</td>
								<td>${product.desc}</td>
								<td>${product.price }</td>
								<td>${product.inventory}</td>
								<td>${product.reorderPoint}</td>
								<td><a class="btn btn-default"
									href="updateProduct?id=${product.id}">修改</a> <a
									class="btn btn-sm btn-danger deleteBtn" href="#"
									data-toggle="modal" data-target="#deleteModal"
									data-id="${product.id}">刪除</a></td>
									<td><form method="POST" action="uploadFile" enctype="multipart/form-data">
         	 					<input type="hidden" name="id" value="${product.id}">
         					 	<input type="file" name="file"><br />
         						 <input type="submit" value="Upload">
         						</form></td>
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
						<form id="deleteForm" action="deleteProduct" method="post">
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