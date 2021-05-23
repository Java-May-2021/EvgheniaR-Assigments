<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="UTF-8">
<title>The Code</title>
</head>
<body>
<form action="/code" method="post">
<h3><c:out value="${error}"/></h3>
<input type="text" name="guess" placeholder="What is the code?">
<button type="submit">Try Code</button>
</form>
</body>
</html>