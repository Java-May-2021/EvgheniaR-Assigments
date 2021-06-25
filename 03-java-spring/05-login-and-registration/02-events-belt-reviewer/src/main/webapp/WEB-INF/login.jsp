<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Login and Registration</title>
</head>
<body>
<div class="container-sm p-5 my-3 bg-dark text-white">
        <h1>Register!</h1>
    
        <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/" modelAttribute="user">
        <div class="form-group ">
            <form:label path="firstName">First Name:</form:label>
            <form:input class="form-control" path="firstName"/>
        </div>
        <div class="form-group">
            <form:label path="lastName">Last Name:</form:label>
            <form:input class="form-control" path="lastName"/>
        </div>
        <div class="form-group ">
            <form:label path="location">Location:</form:label>
            <form:input class="form-control" path="location"/>
        </div>
        <div class="form-group ">
            <form:label path="state">State:</form:label>
            <form:input class="form-control" path="state"/>
        </div>
        <div class="form-group ">
            <form:label path="email">Email:</form:label>
            <form:input class="form-control" path="email"/>
        </div>
        <div class="from-group ">
            <form:label path="password">Password:</form:label>
            <form:password class="form-control" path="password"/>
        </div>
        <div class="form-group ">
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password class="form-control" path="passwordConfirmation"/>
        </div>
            <button class="btn btn-warning">Register!</button>
    </form:form>
        <h1>Login</h1>
        <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
        <div class="form-group ">
            <label for="email" for="email">Email</label>
            <input class="form-control" type="text" id="email" name="email"/>
        </div>
        <div class="form-group ">
            <label for="password">Password</label>
            <input class="form-control" type="password" id="password" name="password"/>
        </div>
            <button class="btn btn-warning">Login!</button>
    </form>
</div> 
</body>
</html>