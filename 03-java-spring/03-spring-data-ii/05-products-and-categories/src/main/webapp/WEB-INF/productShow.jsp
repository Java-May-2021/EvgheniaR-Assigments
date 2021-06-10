<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${product.name }"/></h1>
<h3>Categories:</h3>
<ul>
     <c:forEach items="${product.categories}" var="category">
         <li>${category.name}</li>
     </c:forEach>
</ul>
<form:form action="/products/${product.id }" method="post" modelAttribute="category">
      <select name="category">
           <c:forEach items="${categories}" var="category">
                 <option value="${category.id}">${category.name }<option>
           </c:forEach>
      </select>
      <button type="submit">Create</button>
</form:form>
</body>
</html>