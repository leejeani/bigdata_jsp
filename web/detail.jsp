<%@page import="com.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script></script>
</head>
<body>
<h1>Product Detail</h1>
ID: ${product.id }<br>
NAME: ${product.name }<br>
PRICE: ${product.price }<br>
REGDATE: ${product.regdate }<br>
<a href="">DELETE</a>
<a href="product?cmd=update&id=${product.id }">UPDATE</a>
<a href="main">HOME</a>
</body>
</html>










