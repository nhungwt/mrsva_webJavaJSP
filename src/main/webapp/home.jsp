<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<c:set value="${requestScope.list }" var="categoryList"></c:set>
	<c:set value="${requestScope.cid}" var="cid"></c:set>
	
    <form action="list" style="line-height: 1.8em;" id="form" 
    method="get">
        <span>Product: </span>
        <select name="key" id="category" onchange="hasChange()">
            <option value="0">All</option>
	        <c:forEach items="${categoryList }" var="c">
	            <option ${(cid==c.id)? 'selected':''} value="${c.id}" style="text-transform: capitalize;">${c.name}</option>
	        </c:forEach>
        </select><br>
        <input type="text" name="describe" placeholder="Type name, describe, category"><br>
        Value from <input type="text" name="valueFrom"> &nbsp; &nbsp; Value to <input type="text" name="valueTo"><br>
        Date from <input type="date" name="dateFrom">&nbsp; &nbsp; Date to <input type="date" name="dateTo"><br>
        <input type="submit" value="Search">
    </form>
    
    
    <section id="display">
    
    	<c:forEach items="${requestScope.listProducts}" var="p">
	        <div class="container"
	            style="border: solid #000 1px; padding: 5px; border-radius: 5px;display: inline-block; margin:5px 10px">
	            <img 
	                src="${p.image }" 
	                alt=""
	                style="width: 250px; height: auto;"><br>
	            <span>${p.name}</span><br>
	            <a href="#">View detail</a>
	        </div>
    	</c:forEach>
    </section>
    
    
    <script>
    	function hasChange() {
			document.getElementById("form").submit();
		}
    </script>
</body>
</html>