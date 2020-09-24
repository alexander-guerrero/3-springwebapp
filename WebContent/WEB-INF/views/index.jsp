<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.5.1.min.js" />'></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		alert('It works! :D');
	});
</script>
</head>
<body>
	<h1>Index.jsp</h1>
	<a href='<c:url value="/about" />'>About</a> |
	<a href='<c:url value="/admin" />'>Admin</a>
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
	<p>
		Respuesta luego de enviar el formulario:
		<c:out value="${respuesta}" />
	</p>

	<table border="">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Cargo</th>
			<th>Fecha de Creación</th>
			<th>Acción</th>
		</tr>
		<!-- Iteración mediante JSTL y EL (Expression Language) -->
		<c:forEach items="${adminLista}" var="admin">
			<tr>
				<td><c:out value="${admin.idAdm}"></c:out></td>
				<td><c:out value="${admin.nombre}"></c:out></td>
				<td><c:out value="${admin.cargo}"></c:out></td>
				<td><c:out value="${admin.fechaCreacion}"></c:out></td>
				<td><a href='<c:url value="admin/${admin.idAdm}/update" />'>Modificar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>