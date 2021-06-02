<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Lookify</title>
</head>
<body>
<a href="/songs/new">Add New</a> <span>|</span> <a href="/search/topTen">Top Songs</a>
<form method="post" action="/search" class="flex-container">
<input type="text" name="artist">
<button class="btn btn-primary">Search Artists</button>
</form>
<table class="table table-dark">
    <thead>
        <tr>
            <th>Title</th>
            <th>Artist</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/songs/${song.id }"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="delete/${song.id}">delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>