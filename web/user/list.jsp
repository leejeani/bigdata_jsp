<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
#center{
	margin:0 auto;
	width:780px;
	min-height:380px;
	padding-top:5px;
	background:white;
	text-align: center;
}
#center > table {
	width:300px;
	border:2ps solid red;
	margin:0 auto;
}
</style>
<div id="center">
<h1>User List</h1>
<table>
<thead>
<tr><th>ID</th><th>NAME</th></tr>
</thead>
<tbody>
<c:forEach var="u" items="${userlist }">
<tr>
<td><a href="user.mc?cmd=detail&id=${u.id }">${u.id }</a></td>
<td>${u.name }</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>








