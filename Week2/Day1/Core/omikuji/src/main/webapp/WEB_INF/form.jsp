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
	<h1>Send an Omikuji ! </h1>
	
	<form action="/sendomi" method="post">
	
	<label>Pick any number from 5 to 25</label>
	<input type="number" name="number" >
	
	<label>Enter the Name of the city </label>
	<input type="text" name="cityname" >
	
	<label>Enter the name of any real person </label>
	<input type="text"  name="personname">
	
	<label>Enter professional endeavor or hobby</label>
	<input type="text" name="hobby">
	
	<label>Enter any type of living thing</label>
	<input type="text" name="livingthing">
	
	<label>Say Something nice to someone </label>
	<input type="text" name="somethingnice">
	
	<p> Send and show a friend </p>
	
	<button> Send</button>
	</form>
</div>

</body>
</html>