<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<h1>
	管理員登入介面
</h1>
<P>  輸入帳號密碼 </P>
<form action="newuser" method ="post">
	帳號:<input type="text" name ="account"/></br>
	密碼:<input type="password" name ="password"/></br>
	姓名:<input type="text" name ="name"/></br>
	電話:<input type="text" name ="phone"/></br>
	地址:<input type="text" name ="address"/></br>
	Email:<input type="text" name ="email"/></br>
		<div class="form-group">
						職位:<select class="form-control" name="position">
						<option value="manager">manager</option>
  						<option value="Warehouse staff">Warehouse staff</option>
  						<option value="Purchasing staff">Purchasing staff</option>
  						<option value="Accounting staff">Accounting staff</option>
  						<option value="Salesperson">Salesperson</option>
  						<option></option>
						</select>
					</div>
	<button type="submit" class="btn btn-danger">登入</button>

</form>

</body>
</html>