<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ page isErrorPage="true" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Display Song</title>
</head>
<body>
<div class="container mt-4">
    <div class="card">
        <div class="card-header">
            Song Details
            <h2>Users added this song <span class="badge bg-success"> <c:out value="${song.getUsersAddedThisSong().size() }"></c:out> </span></h2>
        </div>
        <div class="card-body">
            <h5 class="card-title">Title: <c:out value="${song.getTitle() }"></c:out></h5>
            <p class="card-text">URL: <c:out value="${song.getUrl() }"></c:out></p>
            <p class="card-text">Description: <c:out value="${song.getDescription() }"></c:out></p>
        </div>
    </div>
    <div class="card mt-4">
        <div class="card-header">
            Users added this song
        </div>
        <div class="card-body">
            <ul class="list-group list-group-flush">
                <c:forEach var="user" items="${song.getUsersAddedThisSong() }">
                    <li class="list-group-item"><c:out value="${user.getUserName() }"></c:out></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
