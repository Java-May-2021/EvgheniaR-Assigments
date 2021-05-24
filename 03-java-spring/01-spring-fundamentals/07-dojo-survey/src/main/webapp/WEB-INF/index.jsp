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
<form action="/result" method="POST">
<h1>Dojo Survey</h1>
Your Name:<input type="text" name="name" ><br>
Dojo Location:<select name="location">
<option value="Seattle">Seattle</option>
<option value="San Jose">San Jose</option>
<option value="Chicago">Chicago</option>
</select><br>
Favorite language:<select name="language">
<option value="Java">Java</option>
<option value="Python">Python</option>
<option value="JavaScript">JavaScript</option>
</select><br>
<label for="comment">Comment(optional):</label>
<textarea name="comment"></textarea><br>
<button type="submit">Button</button>
</form>
</body>
</html>