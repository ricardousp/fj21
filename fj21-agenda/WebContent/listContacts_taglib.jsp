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
	<%-- this is a jsp comment! :) --%>

	<%="List of contacts"%><br>
	<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDAO" />
	<%--
	<%
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contacts = new ArrayList<Contato>();
		contacts.addAll(dao.getLista());--%>
	<c:forEach var="contact" items="${dao.lista}">
		${contact.nome}, ${contact.endereco}, ${contact.email}, ${contact.dataNascimento.time} <br>
	</c:forEach>
	<%-- 			 	for (Contato c : contacts) {
	%>
	<li><%=c.getNome()%>,<%=c.getEmail()%>:<%=c.getEndereco()%></li>
	<%
		}
	%> --%>
</body>


</html>