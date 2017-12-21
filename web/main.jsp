<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<style>
*{
	margin:0;
	padding:0;
}
a{
	text-decoration: none;
}
header{
	margin:0 auto;
	width: 800px;
	height:150px;
	background:red;
	position: relative;
}
nav{
	margin:0 auto;
	width: 800px;
	height:30px;
	background:pink;
}
section{
	margin:0 auto;
	width: 800px;
	min-height:400px;
	background:gray;
}
footer{
	margin:0 auto;
	width: 800px;
	height:80px;
	background:black;
}
header > #top_menu{
	position: absolute;
	top:0;
	right:0;
	list-style: none
}
header > #top_menu > li{
	float:left;
}
header > #top_menu > li > a{
	margin: 2px;
	font-size: 110%;
	font-weight: bold;
}
header > #top_menu > li > a:hover{
	color:white;
	background:black;
}
header > #main_menu{
	position: absolute;
	left:80px;
	bottom:0;
	list-style: none
}
header > #main_menu > li{
	float:left;
	padding-right: 5px;
}
header > #main_menu > li > a{
	font-size: 150%;
	font-weight: bold;
	padding:0 10px;
}
header > #main_menu > li > a:hover{
	color:white;
	background:black;
}

#center{
	margin:0 auto;
	width:780px;
	main-height:380px;
	padding-top:5px;
	background:white;
	text-align: center;
}
</style>
<script></script>
</head>
<body>
<header>
	<c:choose>
		<c:when test="${loginuser.id == null }">
			<ul id="top_menu">
			<li><a href="main.mc?view=login">LOGIN</a></li>
			<li><a href="main.mc?view=register">REGISTER</a></li>
			<li><a href="main.mc?view=about">ABOUT US</a></li>
		    </ul>
		</c:when>
		<c:otherwise>
		    <ul id="top_menu">
			<li><a href="">${loginuser.name }님</a></li>
			<li><a href="login.mc">LOGOUT</a></li>
			<li><a href="main.mc?view=about">ABOUT US</a></li>
		    </ul>
		</c:otherwise>
	</c:choose>
	
	
	<ul id="main_menu">
		<li><a href="main.mc?view=useradd">USER ADD</a></li>
		<li><a href="user.mc?cmd=list">USER LIST</a></li>
		<li><a href="main.mc?view=productadd">PRODUCT ADD</a></li>
		<li><a href="product.mc?cmd=list">PRODUCT LIST</a></li>
	</ul>
</header>
<nav>
<c:choose>
	<c:when test="${nav != null }">
		${nav }
	</c:when>
	<c:otherwise>
		<a href="main.mc">HOME</a>
	</c:otherwise>
</c:choose>
</nav>
<section>
<c:choose>
	<c:when test="${center != null }">
	    <jsp:include page="${center }.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:include page="center.jsp"/>
	</c:otherwise>
</c:choose>
</section>
<footer></footer>
</body>
</html>











