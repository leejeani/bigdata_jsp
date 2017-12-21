<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
#center > table{
	margin:0 auto;
	border:2px solid red;
}
</style>

<script>

</script>

<div id="center">
<h1>Product List Page</h1>
<table>
	<thead>
		<tr>
			<th>IMG</th><th>ID</th>
			<th>NAME</th><th>PRICE</th>
			<th>REGDATE</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="p" items="${listp }">
		<tr>
			<td><img src="img/${p.imgname }"></td>
			<td><a href="product.mc?cmd=detail&id=${p.id }">${p.id }</a></td>
			<td>${p.name }</td>
			<td>${p.price }</td>
			<td>${p.regdate }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>














