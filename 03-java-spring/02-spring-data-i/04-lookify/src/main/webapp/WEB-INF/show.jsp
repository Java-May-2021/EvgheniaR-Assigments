<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<p><c:out value="${song.title}"/></p>
<p><c:out value="${song.artist}"/></p>
<p><c:out value="${song.rating}"/></p>
<a href="/delete/{id}">Delete</a>
</body>
</html>