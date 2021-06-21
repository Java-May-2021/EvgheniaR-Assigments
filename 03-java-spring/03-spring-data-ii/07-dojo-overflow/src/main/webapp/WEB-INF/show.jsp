<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Question</title>
</head>
<body>
<h1>${question.question}</h1>
    <h3>Answers:</h3> 
   	<ul>
		<c:forEach items="${ question.answers }" var="answer">
			<li>"${ans.answer}"</li>			
		</c:forEach>
	</ul>
<h3>Add your answer:</h3>
		<form:form action="/questions/answers" method="post" modelAttribute="ans">
			 <div class="form-group">
		        <form:label path="answer"></form:label>
		        <form:errors path="answer"/>
		        <form:textarea class="form-control" path="answer" type="text" value="${ans.answer }" ></form:textarea>
		    </div>
		    <form:hidden path="question" value="${ question.id }"/>
		    <button class="btn btn-primary">Submit</button>
		</form:form>		
</body>
</html>
