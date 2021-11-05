<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/test.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>Index Page</h1>
	<div>
		<c:choose>
			<c:when test="${not empty member}">
				<h3>${member.name}님 환영합니다</h3>
				<a href="./member/memberLogout">Logout</a>
			</c:when>
			<c:otherwise>
				<a href="./member/memberLogin">Login</a>
				<a href="./member/memberJoin">Join</a>
			</c:otherwise>
		</c:choose>
	</div>
	
	<img alt="logo.png" src="./images/logo.png">
	<img alt="search.webp" src="./front/search.webp">
</body>
</html>