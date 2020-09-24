<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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

	<sf:form action="${pageContext.request.contextPath}/admin"
		method="post" commandName="admin">
		<table>
			<c:if test="${admin.idAdm ne 0}" >
				<!-- Creación de campos ocultos (Para la opción de Modificar) -->
				<sf:input path="idAdm" type="hidden" />
				<sf:input path="fechaCreacion" type="hidden" />
			</c:if>
			<tr>
				<td>Nombre</td>
				<td><sf:input path="nombre" /></td>
			</tr>
			<tr>
				<td>Cargo</td>
				<td><sf:input path="cargo" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Guardar cambios" />
				</td>
			</tr>
		</table>
	</sf:form>

</body>
</html>