<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Select Page</h1>
	
	<h3>Title : ${boardVO.title}</h3>
	<h3>Writer : ${boardVO.writer}</h3>
	<h3>Contents : ${boardVO.contents}</h3>
	
	<c:forEach items="${boardVO.fileList}" var="fileVO">
		<a href="../upload/${board}/${fileVO.fileName}">${fileVO.oriName}</a>
	</c:forEach>
	
	<a href="./delete?num=${boardVO.num}">Delete</a>
	<a href="./update?num=${boardVO.num}">Update</a>
	<c:if test="${board ne notice}">
		<a href="./reply?num=${boardVO.num}">Reply</a>
	</c:if>
</body>
</html>