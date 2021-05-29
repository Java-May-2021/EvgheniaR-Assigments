<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${book.title}</h1>
<p>Description:<c:out value="${book.description}"/></p>
<p>Language:<c:out value="${book.language}"/></p>
<p>Number of pages:<c:out value="${book.numberOfPage}"/></p>
<a href="/books/edit/${book.id}">Edit Book</a>
<a href="/books">Go back</a>
</body>
</html>