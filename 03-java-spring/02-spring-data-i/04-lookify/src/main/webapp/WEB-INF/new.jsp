<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Lookify</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<form:form action="/dashboard" method="post" modelAttribute="song">
    <div class="form-group col-2">
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input class="form-control" path="title"/>
    </div>
    <div class="form-group col-2">
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input class="form-control" path="artist"/>
    </div>
    <div class="form-group col-1">
        <form:label path="rating">Rating(1-10):</form:label>
        <form:errors path="rating"/>
        <form:select type="number" class="form-control" path="rating">
            <form:option value="1" />
		    <form:option value="2" />
		    <form:option value="3" />
		    <form:option value="4" />
		    <form:option value="5" />
		    <form:option value="6" />
		    <form:option value="7" />
		    <form:option value="8" />
		    <form:option value="9" />
		    <form:option value="10"/>
		</form:select>
    </div>
    <button class="btn btn-primary">Add Song</button>
</form:form>    

</body>
</html>