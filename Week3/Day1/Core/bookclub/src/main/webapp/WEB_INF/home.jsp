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
<title>Home</title>
</head>
<body>
<div class="d-flex justify-content-around mt-4">
<div>
<h1>Welcome, <c:out value="${user.getUserName()}"></c:out>!</h1>
<h3>Books From Everyone's Shelves</h3>
</div>
<div>
<a href="/logout"  class="btn btn-outline-danger"> Log Out</a>
<a href="/addbook"  class="btn btn-outline-primary"> + Add a book to my shelf !</a>
</div>
</div>

<table class="table table-striped">
<thead>
<tr>
<th>Id</th>
<th>Title</th>
<th>Author Name</th>
<th>Posted By</th>


</tr>
</thead>
<tbody>
<c:forEach var="book" items="${books}" >
	<tr>
		<td>
		<a href="/display/${book.id}"> <c:out value="${book.id}"></c:out></a>
		</td>
		<td>
		<a href="/display/${book.id}"><c:out value="${book.title}"></c:out></a>
		</td>
		<td>
		 <c:out value="${book.author}"></c:out>
		</td>
		<td>
		<c:out value="${book.getCreator().getUserName()}"></c:out>
		</td>
		
	</tr>
</c:forEach>
</tbody>

</table>

</body>
</html>