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
<title>Insert title here</title>
</head>
<body>


<form:form action="/edit/${expense.id}" modelAttribute="expense" method="POST" class="mt-4">
<input type="hidden" name="_method" value="PUT">
 
  <div>
 <form:label path="expenceName">Expense Name</form:label>
 <form:input path="expenceName" type="text"/>
 <form:errors path="expenceName"></form:errors>
 </div>
 
  <div>
 <form:label path="vendor">vendor</form:label>
 <form:input path="vendor" type="text"/>
 <form:errors path="vendor"></form:errors>
 </div>
 
  <div>
 <form:label path="amount">Amount</form:label>
 <form:input path="amount" type="number" step="0.01"/>
 <form:errors path="amount"></form:errors>
 </div>
 
 
  <div>
 <form:label path="description">description</form:label>
 <form:input path="description" type="text"/>
 <form:errors path="description"></form:errors>
 </div>

<button>Submit </button>

</form:form>



</body>
</html>