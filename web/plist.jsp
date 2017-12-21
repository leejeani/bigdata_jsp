<%@page import="com.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
table{
	width:300px;
	border:2px solid red;
}
</style>
<script></script>
</head>
<body>
<h1>Product List</h1>
<table>
<tbody>
<c:forEach var="p" items="${plist }">
<tr>
<td><a href="product?cmd=detail&id=${p.id }">${p.id }
</a></td>
<td>${p.name }</td>  
<td>${p.price }</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>






