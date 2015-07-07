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

	<%="List of contacts"%>
	<table>
		<%
			ContatoDAO dao = new ContatoDAO();
			List<Contato> contacts = new ArrayList<Contato>();
			contacts.addAll(dao.getLista());
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY");
			for (Contato c : contacts) {
		%>
		<tr>
			<td><%=c.getNome()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getEndereco()%></td>
			<td><%=formatDate.format(c.getDataNascimento().getTime())%></td>
		</tr>
		<%
			}
		%>
	</table>
</html>