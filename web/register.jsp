<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style></style>
<script>
function register(f){
	var id = f.id.value;
	var pwd = f.pwd.value;
	var name = f.name.value;
	if(id == null || id == ''){
		alert('ID�� �Է� �ϼ���');
		f.id.focus();
		return;
	};
	if(pwd == null || pwd == ''){
		alert('PWD�� �Է� �ϼ���');
		f.pwd.focus();
		return;
	};
	if(name == null || name == ''){
		alert('NAME�� �Է� �ϼ���');
		f.name.focus();
		return;
	};
	var c = confirm('���� �Ͻðڽ��ϱ�?');
	if(c == true){
		f.method='post';
		f.action='register';
		f.submit();
	}
};
</script>
</head>
<body>
<h1>Register Page</h1>
<form>
ID<input type="text" name="id"><br>
PWD<input type="password" name="pwd"><br>
NAME<input type="text" name="name"><br>
<input type="button" value="REGISTER"
onclick="register(this.form);">
</form>
</body>
</html>















