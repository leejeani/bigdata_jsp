<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script>
function register(f){
	var c = confirm('등록 하시겠습니까?');
	if(c == true){
		f.method='POST';
		f.action='product.mc?cmd=add';
		f.submit();
	}
};
</script>

<div id="center">
<h1>Product Add Page</h1>
<form enctype="multipart/form-data">
ID<input type="number" name="id"><br>
NAME<input type="text" name="name"><br>
PRICE<input type="number" name="price"><br>
IMAGE<input type="file" name="img"><br>
<input type="button" value="REGISTER"
onclick="register(this.form);"
><br>
</form>
</div>


