<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Message Wall</title>
</head>
<body>
<div  class="container-sm p-5 my-3 bg-dark text-white">
  <div class="text-right">
    <a class="btn btn-primary" href="/events">Go Back</a>
  </div>
   <h1>${event.name }</h1>
   <p><strong>Host:</strong> ${event.planner.firstName } ${event.planner.lastName }</p>
   <p><strong>Date: </strong><fmt:formatDate value="${event.date}" pattern="MMMM dd,yyyy"/></p>
   <p><strong>Location:</strong> ${event.location },  ${event.state }</p>
   <h4><strong>People attending this event:</strong> ${event.attendees.size() }</h4>
   <table class="table table-primary">
    <thead>
        <tr>
            <th>Name</th>
            <th>Location</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${event.attendees}" var="attendent">
        <tr>
            <td><c:out value="${attendent.firstName} ${attendent.lastName }"/></td>
            <td><c:out value="${attendent.location}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<h1>Message Wall</h1>
<div class="message">
    <c:forEach items="${event.messages }" var="message">
       <p>${message.author.firstName } says:${message.content }</p>
       <p>--*--*--*--*--*--*--*</p>
    </c:forEach>
</div>
 <form:form method="POST" action="/events/${event.id}/comment" modelAttribute="newMessage">
        <div class="form-group ">
            <form:label path="content">Add Comment:</form:label>
            <form:errors path="content"/>
            <form:textarea class="form-control" path="content"/>
        </div>
        <button class="btn btn-primary">Submit</button>
 </form:form>
</div>
</body>
</html>