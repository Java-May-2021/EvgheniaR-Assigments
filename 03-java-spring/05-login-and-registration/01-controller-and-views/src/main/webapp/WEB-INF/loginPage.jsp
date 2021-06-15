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
 <h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
        <div class="form-group">
            <label for="email" for="email">Email</label>
            <input class="form-control" type="text" id="email" name="email"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input class="form-control" type="password" id="password" name="password"/>
        </div>
        <button class="btn btn-warning">Login!</button>
    </form>
</div>    
</body>
</html>