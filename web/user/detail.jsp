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
function register(f){
	var c = confirm('등록 하시겠습니까?');
	if(c == true){
		f.method='POST';
		f.action='user.mc?cmd=add';
		f.submit();
	}
};
$(document).ready(function(){
	$('#deluser').click(function(){
		var id = '${detailuser.id }';
		var c = confirm('삭제 하시겠씁니까?');
		if(c == true){
			location.href='user.mc?cmd=delete&id='+id;
		}
	});
	$('#upuser').click(function(){
		var id = '${detailuser.id }';
		var c = confirm('수정 하시겠습니까?');
		if(c == true){
			location.href='user.mc?cmd=update&id='+id;
		}
	});
});
</script>
<div id="center">
<h1>User Detail</h1>
ID: ${detailuser.id }<br>
PWD ${detailuser.pwd }<br>
NAME ${detailuser.name }<br>
<button id="deluser">DELETE</button>
<button id="upuser">UPDATE</button>
</div>








