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
		<h1>Join Page</h1>
		<form:form modelAttribute="memberVO" enctype="multipart/form-data">
			<div class="mb-3 mt-3">
				<label for="id" class="form-label">ID:</label>
				<form:input path="id" id="id" cssClass="form-control" />
				<form:errors path="id"></form:errors>
			</div>
			<div class="mb-3 mt-3">
				<label for="pw" class="form-label">PW:</label>
				<form:input path="pw" id="pw" cssClass="form-control" />
				<form:errors path="pw"></form:errors>
			</div>
			<div class="mb-3 mt-3">
				<label for="pwCheck" class="form-label">PWCheck:</label>
				<form:input path="pwCheck" id="pwCheck" cssClass="form-control" />
				<form:errors path="pwCheck"></form:errors>
			</div>
			<div class="mb-3 mt-3">
				<label for="name" class="form-label">Name:</label>
				<form:input path="name" id="name" cssClass="form-control" />
				<form:errors path="name"></form:errors>
			</div>
			<div class="mb-3 mt-3">
				<label for="email" class="form-label">Email:</label>
				<form:input path="email" id="email" cssClass="form-control" />
				<form:errors path="email"></form:errors>
			</div>
			<div class="mb-3 mt-3">
				<label for="age" class="form-label">Age:</label>
				<form:input path="age" id="age" cssClass="form-control" />
				<form:errors path="age"></form:errors>
			</div>
			<div class="mb-3 mt-3">
				<label for="birth" class="form-label">Birth:</label>
				<form:input path="birth" id="birth" cssClass="form-control" />
				<form:errors path="birth"></form:errors>
			</div>
			<div>
				<button type="submit" class="btn btn-secondary mt-4">Join</button>
			</div>
		</form:form>
	</div>
</body>
</html>