<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-sm p-5 my-3 bg-dark text-white">
  <h1>Register!</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <div class="form-group ">
            <form:label path="email">Email:</form:label>
            <form:input class="form-control" path="email"/>
        </div>
        <div class="from-group">
            <form:label path="password">Password:</form:label>
            <form:password class="form-control" path="password"/>
        </div>
        <div class="form-group">
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password class="form-control" path="passwordConfirmation"/>
        </div>
        <button class="btn btn-warning">Register!</button>
    </form:form>
</div>
</body>
</html>