<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
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
    
    <title>產品管理</title>
    
</head>
<body>

	<%@include file="sidebar.jspf" %>
	<%@include file="navbar.jspf" %>
    
    <div class="container theme-showcase" role="main">
    
     <div class="jumbotron" style="margin-left: 8cm;">   
        <h1>登入成功!</h1>
        <p class="lead">請選擇管理功能</p>
      </div>
 
    </div><!-- /.container -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>


</body>
</html>