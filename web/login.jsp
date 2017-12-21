<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
#center{
	margin:0 auto;
	width:780px;
	height:380px;
	padding-top:5px;
	background:white;
	text-align: center;
}
</style>
<script>
function login(f){
	var c = confirm('로그인 하시겠습니까?');
	if(c == true){
		f.method='POST';
		f.action='login.mc';
		f.submit();
	}
};
</script>
<div id="center">
<h1>Login Page</h1>
<form>
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
<input type="button" value="LOGIN"
onclick="login(this.form);"><br>
</form> 
</div>













