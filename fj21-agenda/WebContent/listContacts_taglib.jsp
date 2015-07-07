<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.caelum.jdbc.dao.ContatoDAO"%>
<%@page import="br.com.caelum.jdbc.modelo.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
	<%="List of contacts"%><br>
	<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDAO" />
	<table border="1">
		<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
			<td>Name</td>
			<td>Address</td>
			<td>Email</td>
			<td>Birth</td>
		</tr>
		<c:forEach var="contact" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contact.nome}</td>
				<td>${contact.endereco}</td>
				<td>
					<c:if test="${not empty contact.email}">
						<a href="mailto:${contact.email}">${contact.email}</a>
					</c:if>
					<c:if test="${empty contact.email }">
						N/A
					</c:if></td>
				<td>${contact.dataNascimento.time}</td>
			</tr>
		</c:forEach>
	</table>
</body>


</html>