<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class ="container">
			<h1>Questions Dashboard</h1>
			<hr>
			<table class="table table-dark">
				<thead>
				<tr>
					<td>Question</td>
					<td>Tags</td>
				</tr>
				</thead>
				<tbody>
					<c:forEach items ="${allQuestions}" var ="quest">
						<tr>
							<td><a href="/questions/${quest.id}">${quest.question}</a></td>
    						<c:forEach items="${allTags}" var="tags">
    						<td><c:out value="${quest.tags}"/></td>
    						</c:forEach>
						</tr>
					</c:forEach>	
				</tbody>				
			</table>
			<h3><a href="questions/new">Add a Question</a></h3>
		</div>
</body>
</html>