<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add a new Category</h1>
	
	<form action="addCategory" method="post">
		ID: <input type="number" name="id" /><br />
		Name: <input type="text" name="name" /><br />
		Describe: <input type="text" name="describe" /><br />
		<input type="submit" value="Add" />
	</form>
</body>
</html>