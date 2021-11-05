<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	
	<form action="./memberJoin" method="post" enctype="multipart/form-data">
		ID : <input type="text" name="id"><br>
		PW : <input type="text" name="pw"><br>
		Name : <input type="text" name="name"><br>
		Email : <input type="email" name="email"><br>
		Photo : <input type="file" name="files"><br>
	<button type="submit">Join</button>
	</form>
</body>
</html>