<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="dao" required="true"
	type="br.com.caelum.jdbc.dao.ContatoDAO"%>
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
			<td><c:choose>
					<c:when test="${not empty contact.email}">
						<a href="mailto:${contact.email}">${contact.email}</a>
					</c:when>
					<c:when test="${empty contact.email }">
						N/A
					</c:when>
				</c:choose></td>
			<!-- formatting date -->
			<td><fmt:formatDate value="${contact.dataNascimento.time}"
					pattern="MM/dd/YYYY" /></td>
		</tr>
	</c:forEach>
</table>