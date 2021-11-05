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
	<h1>MemberList Page</h1>
	
	<table>
		<tr>
			<td>ID</td><td>NAME</td><td>EMAIL</td><td>IMAGE</td>
		</tr>
		
		<c:forEach items="${memberList}" var="vo">
		<tr>
			<td>${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.email}</td>
			<td>
				<img alt="photo" src="../upload/member/${vo.memberFilesVO.fileName}">
			</td>
		</tr>
	</c:forEach>
		
	</table>
</body>
</html>