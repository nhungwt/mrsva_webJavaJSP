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
	<c:set var="c" value="${requestScope.category}"></c:set>
	<h1>Update Category: ${c.name }</h1>  
	
	<form action="updateCategory" method="post">
		ID: <input type="number" name="id" readonly="readonly" value="${c.id}"/><br />
		Name: <input type="text" name="name"  value="${c.name}"/><br />
		Describe: <input type="text" name="describe" value="${c.describe}" /><br />
		<input type="submit" value="Update" />
	</form>
</body>
</html>