<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<style type="text/css">
		#demo{
		}
	</style>
</head>
<body>
	<h1>List of Categories</h1>
	<p><a href="addCategory">Add a Category</a></p>
	
	<table border="1px" width="40%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Describe</th>
			<th colspan="2">Actions</th>
			<th>List of Products</th>
		</tr>
		
		<c:forEach var="c" items="${requestScope.list }">
		<c:set var="id" value="${c.id}" />
		<tr>
			<td>${id}</td>
			<td>${c.name}</td>
			<td>${c.describe}</td>
			<td><a href="updateCategory?id=${id}">Update</a></td>
			<td><a href="#" onclick="deleteCategory(${id})">Delete</a></td>
			<td><a href="listProducts?id=${id}">View</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<br>
	<br>
	<br>
	
	<c:set var="exception" value="${requestScope.listProduct}"></c:set>
	<c:if  test="${exception != null}">
	
		<h3>List of <span style="font-size: xx-large; color: navy;">${exception[0].category.name}</span></h3>
		
	<div id="demo">
		<table border="1px" width="40%">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Image</th>
				<th>Category</th>
				<th colspan="2">Actions</th>
			</tr>
			
			<c:forEach var="p" items="${exception}">
			<c:set var="id_p" value="${p.id}" />
			<tr>
				<td>${id_p}</td>
				<td>${p.name}</td>
				<td>${p.quantity}</td>
				<td><img src="${p.image}" alt="" style="width: 250px; height: auto" /></td>
				<td>${p.category.name}</td>
				<td><a href="updateCategory?id=${id_p}">Update</a></td>
				<td><a href="#" onclick="deleteCategory(${id_p})">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</c:if>
	
	<script type="text/javascript">
		function deleteCategory(id) {
			if(confirm("Are u sure to delete this Category with id is "+id)){
				window.location = "deleteCategory?id="+id;
			}
		}
		
		function view() {
			document.getElementById("demo").style.display = "block";
		}
	</script>
</body>
</html>