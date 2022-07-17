<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var= "c" value="${requestScope.user }" />
	<h1>Edit User ${u.username}</h1>
	
	<form action="editUserServlet" method="post">
		Username: <input type="text" name="username" value="${c.username}" /><br />
		Password: <input type="password" name="pass" value="${c.pass}" /><br />
		<input type="submit" value="Update">
		
	</form>
</body>
</html>