<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 <%@ page isErrorPage="true" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Edit Book Page</title>
</head>
<body>


<div class="d-flex justify-content-around mt-4" >
<h1>Change your Entry !</h1>
<a href="/books" class="btn btn-outline-success">Back to the shelves</a>
</div>


<form:form action="/edit/${book.id}" method="POST" modelAttribute="book">
<input hidden  name="_method" value="PUT">

	<div class="mb-3">
		<form:label path="title" class="form-label">title:</form:label>
		<form:input path="title" class="form-control"/>
		<form:errors path="title" cssClass="text-danger"></form:errors>
	</div>
	
	<div class="mb-3">
         <form:label path="author" class="form-label">author:</form:label>
         <form:input path="author" class="form-control"/>
         <form:errors path="author" cssClass="text-danger"></form:errors>
    </div>
    
    <div class="mb-3">
         <form:label path="thoughts" class="form-label">thoughts:</form:label>
         <form:input path="thoughts" class="form-control"/>
         <form:errors path="thoughts" cssClass="text-danger"></form:errors>
    </div>
<button type="submit" class="btn btn-primary w-30">update Book</button>
</form:form>





</body>
</html>