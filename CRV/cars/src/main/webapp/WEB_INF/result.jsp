<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
	
		<span class="badge bg-success" >${success }</span>
		<h1>Show Car</h1>
		<p>Make : ${make }</p>
		<p>Model : ${model }</p>
		<p>year : ${year }</p>
		<p style="background-color: ${color}">Color  : ${color }</p>
		
		<hr>
		<c:if test="${year==2025 }">
			<p> Your Car is New </p>
		</c:if>
		
	</div>


</body>
</html>