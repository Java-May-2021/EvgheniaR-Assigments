<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
</head>
<body>
<h1><c:out value="${person.firstName } ${person.lastName }"/></h1>
<p>License Number:000000<c:out value="${person.license.id}"/></p>
<p>State:<c:out value="${person.license.state}"/></p>
<p>Expiration Date:<c:out value="${person.license.expirationDate }"/> </p>
</body>
</html>