<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/BootstrapCDN.jsp"></c:import>
</head>
<body>
	<div class="container mt-3">
		<h1>${board} Reply Page</h1>
		<form:form modelAttribute="boardVO" enctype="multipart/form-data">
			<form:hidden path="num"/>
			<div class="mb-3 mt-3">
				<label for="title" class="form-label">Title:</label>
				<form:input path="title" id="title" cssClass="form-control" />
				<form:errors path="title"></form:errors>
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer:</label>
				<form:input path="writer" id="writer" cssClass="form-control"/>
				<form:errors path="writer"></form:errors>
			</div>
			<div class="mb-3">
				<label for=contents class="form-label">Contents:</label>
				<form:textarea path="contents" id="contents" cssClass="form-control"/>
			</div>
			<div>
				<input type="file" name="files" class="form-control"><br>
				<input type="file" name="files" class="form-control">
			</div>
			<div>
				<button type="submit" class="btn btn-secondary mt-4">Write</button>
			</div>
		</form:form>
	</div>
</body>
</html>