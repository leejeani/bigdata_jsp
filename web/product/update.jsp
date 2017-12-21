<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script>

</script>
<script>
function update(f){
	var c = confirm('수정하시겠습니까?');
	if(c == true){
		f.method='POST';
		f.action='product.mc?cmd=updateimpl';
		f.submit();
	}
};
</script>
<div id="center">
<h1>Product Update Page</h1>
<form enctype="multipart/form-data">
ID: ${updatep.id }<br>
<input type="hidden" name="id" 
value="${updatep.id }">
NAME: <input type="text" name="name"
value="${updatep.name }"><br>
PRICE:<input type="number" name="price"
value="${updatep.price }"><br>
REGDATE: ${updatep.regdate }<br>
IMG:<input type="file" name="newimgname">
<input type="hidden" name="imgname"
value="${updatep.imgname }"><br>
<input type="button" value="UPDATE"
onclick="update(this.form);">
</form>
</div>














