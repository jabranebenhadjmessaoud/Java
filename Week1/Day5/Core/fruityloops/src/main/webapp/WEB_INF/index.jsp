<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Fruity Loops </title>
</head>
<body>
<div class="container mt-5">
<h1 style="color:pink; margin-bottom:15px">Fruits Store </h1>
<table class="table table-hover" style="border: 30px solid pink">
<thead>
<tr>
<th>Name</th>
<th>Price</th>
</tr>
</thead>
<tbody>
<c:forEach var="fruit" items="${fruits}">
<tr>
<td><c:out value="${fruit.getName()}"></c:out></td>
<td><c:out value="${fruit.getPrice()}"></c:out></td>
	
</c:forEach>
</tr>
</tbody>



</table>
</div>
</body>
</html>