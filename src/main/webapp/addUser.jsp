<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add User</h1>
	<p><a href="db-connect">View list</a></p>
	<form action="addUserServlet">
		Username: <input type="text" name="username" /><br />
		Password: <input type="password" name="pass" /><br />
		<input type="submit" value="Add">
		
	</form>
	<h4>${requestScope.inform}</h4>
</body>
</html>