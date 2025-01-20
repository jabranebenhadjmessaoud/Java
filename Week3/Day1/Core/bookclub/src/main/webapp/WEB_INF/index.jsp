<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>LoginAndRegistration</title>
</head>
<body class="container mt-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h1 class="text-center mb-4">Register</h1>
            <form:form action="/register" method="POST" modelAttribute="newUser" class="needs-validation">
                <div class="mb-3">
                    <form:label path="userName" class="form-label">UserName:</form:label>
                    <form:input path="userName" class="form-control"/>
                    <form:errors path="userName" cssClass="text-danger"></form:errors>
                </div>
                <div class="mb-3">
                    <form:label path="email" class="form-label">Email:</form:label>
                    <form:input path="email" class="form-control"/>
                    <form:errors path="email" cssClass="text-danger"></form:errors>
                </div>
                <div class="mb-3">
                    <form:label path="password" class="form-label">Password:</form:label>
                    <form:input type="password" path="password" class="form-control"/>
                    <form:errors path="password" cssClass="text-danger"></form:errors>
                </div>
                <div class="mb-3">
                    <form:label path="confirm" class="form-label">Confirm Password:</form:label>
                    <form:input type="password" path="confirm" class="form-control"/>
                    <form:errors path="confirm" cssClass="text-danger"></form:errors>
                </div>
                <button type="submit" class="btn btn-primary w-100">Register</button>
            </form:form>
            <hr>
            <h1 class="text-center mb-4">Login</h1>
            <form:form action="/login" method="POST" modelAttribute="newLogin" class="needs-validation">
                <div class="mb-3">
                    <form:label path="email" class="form-label">Email:</form:label>
                    <form:input path="email" class="form-control"/>
                    <form:errors path="email"></form:errors>
                </div>
                <div class="mb-3">
                    <form:label path="password" class="form-label">Password:</form:label>
                    <form:input type="password" path="password" class="form-control"/>
                    <form:errors path="password"></form:errors>
                </div>
                <button type="submit" class="btn btn-primary w-100">Login</button>
            </form:form>
        </div>
    </div>
</body>
</html>
