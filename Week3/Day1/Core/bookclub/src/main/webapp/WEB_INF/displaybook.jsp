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
<title>Display Book Page</title>
</head>


<body>

<div class="d-flex justify-content-around mt-4">
<h1>${book.title}</h1>
<a href="/books" class="btn btn-outline-success">Back to the shelves</a>
</div>

<h2> <strong style="color:red"> <c:out value="${book.getCreator().getUserName()}" ></c:out></strong>  read  <strong style="color:purple"><c:out value="${book.title}" ></c:out></strong> by <strong style="color:green" ><c:out value="${book.author}" ></c:out></strong> </h2>

<h3>Here are <c:out value="${book.getCreator().getUserName()}" ></c:out>'s thoughts : </h3>
<hr/>
<fieldset>
	<p><c:out value="${book.thoughts}"></c:out></p> 
</fieldset>
<hr/>
<div class="d-flex justify-items-center mt-4">
	<c:if test="${book.getCreator().getId().equals(user.getId()) }">
	<a href="/edit/${book.id }" class="btn btn-warning">Edit</a>
	</c:if>
	<c:if test="${!book.getCreator().getId().equals(user.getId()) }">
	<button disabled class="btn btn-warning">Edit</button>
	</c:if>
	
	<c:if test="${book.getCreator().getId().equals(user.getId()) }">
	<a href="/delete/${book.id}" class="btn btn-danger">delete</a>
	</c:if>
	<c:if test="${!book.getCreator().getId().equals(user.getId()) }">
	<button disabled class="btn btn-danger">Delete</button>
	</c:if>
	
	
	
</div>

</body>
</html>