<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="myCustomTaglib" %>
<!DOCTYPE html>
<html>
<head>
	<link href="jquery-ui.css" rel="stylesheet">
	<script src="jquery.js"></script>
	<script src="jquery-ui.js"></script>
</head>
<body>
	<c:import url="header.jsp" />
	<h1>Add contact</h1>
	<hr />
	<form action="addContact" method="get">
		Name: <input type="text" name="name" /><br /> 
		E-mail: <input type="text" name="email" /><br /> 
		Address: <input type="text" name="address" /><br /> 
		Birth: <myCustomTaglib:readDateField id="birth" /><br />
		<input type="submit" value="Save" />
	</form>
	<c:import url="footer.jsp" />
</body>
</html>