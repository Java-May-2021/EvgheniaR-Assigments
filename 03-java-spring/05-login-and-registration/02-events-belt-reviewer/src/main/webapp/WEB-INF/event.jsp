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
<title>Insert title here</title>
</head>
<body>
<div class="container-sm p-5 my-3 bg-dark text-white">
<h1>Welcome, <c:out value="${user.firstName}" /></h1>
    <div class="text-right">
	    <a class="btn btn-primary" href="/logout">Logout</a>
	</div>
	<h3>Here are some of the events in your state:</h3> 
	<c:if test="${inState.size() == 0}"><h5>There are currently no events in your state </h5></c:if>
	<c:if test = "${inState.size() > 0}"> 
       <table class="table table-primary">
           <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>Host</th>
                    <th>Action/Status</th>
                </tr>
           </thead>
           <tbody>
               <c:forEach items="${inState}" var="event">
                  <tr>
                     <td><a href="events/${event.id }">${event.name}</a></td>
                     <td><fmt:formatDate value="${event.date}" pattern="MMMM dd,yyyy"/></td>
                     <td><c:out value="${event.location}"/></td>
                     <td><c:out value="${event.planner.firstName}"/></td>
                     <td>
                        <c:choose>
                            <c:when test="${event.planner.id == user.id }">
                                   <a href="/events/${event.id }/edit">Edit</a>|<a href="/events/${event.id }/delete">Delete</a>
                            </c:when>
                        <c:otherwise>
                           <c:choose>
                               <c:when test="${event.attendees.contains(user)}">
                                   <span>Joining</span>  |  <a href="/events/${event.id }/cancel">Cancel</a>
                               </c:when>
                               <c:otherwise><a href="/events/${event.id }/join">Join</a></c:otherwise>
                           </c:choose>
                        </c:otherwise>
                        </c:choose>
                     </td>
                 </tr>
               </c:forEach>
           </tbody>
       </table>
    </c:if>
    <h3>Here are some of the events in other state:</h3> 
	<c:if test="${outState.size() == 0}"><h5>There are currently no events in other state </h5></c:if>
	<c:if test = "${outState.size() > 0}"> 
       <table class="table table-primary">
           <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>Host</th>
                    <th>Action/Status</th>
                </tr>
           </thead>
           <tbody>
               <c:forEach items="${outState}" var="event">
                  <tr>
                     <td><a href="events/${event.id }">${event.name}</a></td>
                     <td><fmt:formatDate value="${event.date}" pattern="MMMM dd,yyyy"/></td>
                     <td><c:out value="${event.location}"/></td>
                     <td><c:out value="${event.planner.firstName}"/></td>
                     <td>
                        <c:choose>
                            <c:when test="${event.planner.id == user.id }">
                                   <a href="/events/${event.id }/edit">Edit</a>|<a href="/events/${event.id }/delete">Delete</a>
                            </c:when>
                        <c:otherwise>
                           <c:choose>
                               <c:when test="${event.attendees.contains(user)}">
                                   <span>Joining</span>  |  <a href="/events/${event.id }/cancel">Cancel</a>
                               </c:when>
                               <c:otherwise><a href="/events/${event.id }/join">Join</a></c:otherwise>
                           </c:choose>
                        </c:otherwise>
                        </c:choose>
                     </td>
                 </tr>
               </c:forEach>
           </tbody>
       </table>
    </c:if>
    <h2>Create an event</h2>
             <form:form method="POST" action="/events" modelAttribute="event">
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
		        <button class="btn-btn-dark">Create event!</button>
             </form:form>
</div>
</body>
</html>