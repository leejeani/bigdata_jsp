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
function update(f){
	var c = confirm('수정 하시겠습니까?');
	if(c == true){
		f.method='POST';
		f.action='user.mc?cmd=updateimpl';
		f.submit();
	}
};

</script>
<div id="center">
<h1>User Update</h1>
<form>
ID: ${updateuser.id }<br>
<input type="hidden" name="id" 
value="${updateuser.id }">
PWD <input type="text" name="pwd" 
value="${updateuser.pwd }"><br>
NAME <input type="text" name="name" 
value="${updateuser.name }"><br>
<button onclick="update(this.form);">
UPDATE</button>
</form>
</div>








