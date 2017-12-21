<%@page import="com.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script>
function update(f){
	var c = confirm('수정 하시겠습니까?');
	if(c == true){
		f.method='POST';
		f.action='product?cmd=updateimpl';
		f.submit();
	}
};
</script>
</head>
<body>
<h1>Product Update</h1>
<form>
ID: ${product.id }<br>
<input type="hidden" name="id" value="${product.id }">
NAME: <input type="text" name="name" value="${product.name }"><br>
PRICE: <input type="number" name="price" value="${product.price }"><br>
<input type="button" value="수정" onclick="update(this.form);">
</form>
</body>
</html>










