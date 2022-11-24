<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="loginstudent" modelAttribute="student">

		<form:label path="email">EMAIL:</form:label>
		<form:input path="email" />

		<form:label path="password">password:</form:label>
		<form:input path="password" />

		<input type="submit" value="login">

	</form:form>

</body>
</html>