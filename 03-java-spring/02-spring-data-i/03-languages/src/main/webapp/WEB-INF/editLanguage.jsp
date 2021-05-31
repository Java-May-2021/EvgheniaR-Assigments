<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Language: <c:out value="${language.name}"/> </h1>
<a href="/languages/${language.id}/delete">Delete</a> <span>|</span> <a href="/languages">Home</a>
<form:form action="/languages" method="post" modelAttribute="language">
    <p class="form-group row">
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p class="form-group row">
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p class="form-group row">
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>