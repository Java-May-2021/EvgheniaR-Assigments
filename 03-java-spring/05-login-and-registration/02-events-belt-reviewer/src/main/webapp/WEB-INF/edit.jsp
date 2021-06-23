<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-sm p-5 my-3 bg-dark text-white">
    <h2>Edit ${event.name} </h2>
             <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
                 <form:input type="hidden" value="${user.id }" path="planner"/>
                 <div class="form-group col-7">
                     <form:label path="name">Name</form:label>
                     <form:input class="form-control" path="name"/>
                 </div>
                 <div class="form-group col-7">
                     <form:label path="Date">Date</form:label>
                     <form:input class="form-control" type="date" path="date"/>
                 </div>
                 <div class="form-group col-7">
                     <form:label path="location">Location</form:label>
                     <form:input class="form-control" path="location"/>
                 </div>
                 <div class="form-group col-7">
			           <form:label path="state">State</form:label>
			           <form:errors path="state"/>
                       <form:input class="form-control" path="state"/>
		        </div>
		        <button class="btn-btn-dark">Update event!</button>
             </form:form>
</div>
</body>
</html>