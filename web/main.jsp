<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<style>
	div{
		width:400px;
		border:2px solid red;
	}
</style>
<script>
function display(data){
	var output = '';
	$(data).each(function(index,item){
		output += '<h3>';
		output += item.id+' '+item.name+' '
		          +item.price+' '+item.regdate;
		output += '</h3>';
	});
	$('div').html(output);
};

$(document).ready(function(){
	$('button').click(function(){
		$.ajax({
			url:'productajax',
			success:function(data){
				display(data);
			}
		});
	});
});

</script>
</head>
<body>
<h1>Main Page</h1>
<!-- LOGIN 처리 -->
<c:choose>
	<c:when test="${loginuser.id != null}">
		<h3>${loginuser.id } ${loginuser.name }</h3>
		<h3><a href="login">Logout</a></h3>
	</c:when>
	<c:otherwise>
	    <h3><a href="main?cmd=login">LOGIN</a></h3>
	</c:otherwise>
</c:choose>



<h3><a href="main?cmd=register">REGISTER</a></h3>
<h3><a href="product?cmd=add">PRODUCT ADD</a></h3>
<h3><a href="product?cmd=list">PRODUCT LIST</a></h3>
<h3><a href="user?cmd=add">USER ADD</a></h3>
<h3><a href="user?cmd=list">USER LIST</a></h3>

<c:if test="${loginuser.id != null }">
<button>Product AJAX</button>
<div></div>
</c:if>

</body>
</html>







