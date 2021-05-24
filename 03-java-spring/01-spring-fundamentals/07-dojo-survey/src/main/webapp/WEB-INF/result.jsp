<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
</head>
<body>
<h2>Submitted Info</h2>
<h3>Name:${name}</h3>
<h3>Dojo location:${location}</h3>
<h3>Favorite Language:${language}</h3>
<h3>Comment:${comment}</h3>
<a href="/">Go back to home page</a>
</body>
</html>