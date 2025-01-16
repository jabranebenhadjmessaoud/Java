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

<div class="container" >
	<h1>Cars Form </h1>
	<h3 class="text-danger">${yearError}</h3>
	<form action="/processCar" method="post">
	make : <input name="make" > <br>
	model : <input name="model" > <br>
	year : <input type="number" name="year" > <br>
	color : <input type="color" name="color" > <br>
	<button>Create Car</button>
	</form>
</div>

</body>
</html>