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

	<%
		String message = "Welcome to the FJ-21 Agenda Web System!!! \\D:/";
	%>
	<%=message%>
	<br />
	<%
		String developedBy = "Developed By damascenodiego";
	%>

	<%
		out.println(developedBy);
	%>
	<%
		System.out.println("it works!");
		System.out.println("only printed in the server CLI"); 
	%> <%-- this tag will be printed in the server CLI --%>
</body>
</html>