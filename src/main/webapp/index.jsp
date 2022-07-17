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
	<h1>List of users</h1>
	<p><a href="addUser.jsp">Add User</a></p>
	<table border="1px" width="40%">
		<tr>
			<th>Username</th>
			<th>pass</th>
			<th colspan=2>Edit</th>
		</tr>
		<c:forEach items="${ requestScope.data }" var="c">
			<tr>
				<td>${c.username}</td>
				<td>${c.pass}</td>
				<td style="padding: 0px 7px"><a href="editUserServlet?username=${c.username}">Edit</a></td>
				<td style="padding: 0px 7px"><a href="#" onclick="doDelete('${c.username}')">Delete</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
	<script>
		function doDelete(username) {
			if(confirm("Are y sure to delete user?")){
				window.location="delete?username="+username;
			}
		}
	</script>
</body>
</html> 