<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
         <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
     
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Burgers</title>
</head>
<body class="container mt-3">
<div class="container mt-5">
        <h1 class="mt-4">Edit Burger</h1>
        <form:form modelAttribute="burger" method="POST" action="/edit/${burger.id}">
            <div>
                
                <form:label path="burgerName">Burger Name: </form:label>
                <form:input type="text" path="burgerName" class="form-control"/>
                <form:errors class="badge text-danger" path="burgerName"/>
            </div>
            <div>
                
                <form:label path="restaurantName">Restaurant Name: </form:label>
                <form:input path="restaurantName" class="form-control"/>
                <form:errors  class="badge text-danger"  path="restaurantName"/>
            </div>
            <div>
                <form:label path="rating">Rating:</form:label>
                <form:input min="1" max="4" type="number" path="rating" />
                <form:errors path="rating"/>
            </div>
            <div> 
            <form:label path="notes">Notes: </form:label>
			<form:textarea path="notes"  class="form-control" rows="3"></form:textarea>
             <form:errors path="notes"/> 
             </div>
            
            <button type="submit" class="btn btn-primary mt-4">Create</button>
        </form:form>
    </div>
</body>
</html>