<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 <%@ page isErrorPage="true" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- Bootstrap 5 CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
<!-- Font Awesome CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/styles.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-4">
<h1>Welcome back <c:out value="${user.getUserName() }"></c:out></h1>
<!-- Logout  -->
<a href="/logout" class="btn btn-danger">Logout</a>
<a href="/create" class="btn btn-info">Post A song</a>
<a href="/playlist" class="btn btn-success">My PlayList</a>
 <form action="/songs/search" method="GET" class="mb-3 mt-4"> 
        <div class="input-group"> 
        <input type="text" name="query" class="form-control" placeholder="Search song..."> 
        <button type="submit" class="btn btn-primary">Search</button> 
        </div> 
        </form>
<hr>
<table class="table table-striped">
<thead>
<tr>
<th>Song</th>
<th>Posted By</th>
<th>Action</th>

</tr>
</thead>
<tbody>
<c:forEach var="song" items="${songs}" >
<tr>
<td>

<a href="/display/${song.id}"> <c:out value="${song.title}"></c:out></a>

</td>
<td>
<c:out value="${song.getCreator().getUserName()}"></c:out>

</td>
<td>
<c:if test="${song.getCreator().getId().equals(user.getId()) }">
<a href="/edit/${song.id }" class="btn btn-primary">Edit</a>
</c:if>
<c:if test="${!song.getCreator().getId().equals(user.getId()) }">
<button disabled class="btn btn-primary">Edit</button>
</c:if>
<c:if test="${user.getPlayList().contains(song) }">
<a href="/remove/${song.id }" class="btn btn-primary">Remove</a>
</c:if>
<c:if test="${!user.getPlayList().contains(song) }">
<a href="/add/${song.id }" class="btn btn-primary">Add</a>
</c:if>
</td>
</tr>
</c:forEach>
</tbody>

</table>
</div>
</body>
</html>