<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
	<h1>Admin.jsp</h1>
	<a href='<c:url value="/" />'>Home</a> |
	<a href='<c:url value="/about" />'>About</a>
	<p>
		<strong>Admin.jsp: </strong>
		<c:out value="${txtAdmin}" />
	</p>
	<p>
		<strong>Index.jsp: </strong>
		<c:out value="${sessionScope.txtIndex}" />
	</p>
	<p>
		<strong>About.jsp: </strong>
		<c:out value="${sessionScope.txtAbout}" />
	</p>
	<p>
		Las variables de sesión se pueden referenciar de forma implícita
		omitiendo el Scope. Tener en cuenta la información de <a
			href="https://stackoverflow.com/questions/17590620/are-session-and-sessionscope-the-same-in-jsp-el"
			target="_blank">aquí</a>.
	</p>
</body>
</html>