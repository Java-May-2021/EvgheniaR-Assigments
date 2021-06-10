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
<h1><c:out value="${category.name }"/></h1>
<h3>Products:</h3>
<ul>
     <c:forEach items="${category.products}" var="product">
         <li>${product.name}</li>
     </c:forEach>
</ul>
<form:form action="/categories/${category.id }" method="post" modelAttribute="product">
      <select name="product">
           <c:forEach items="${products}" var="product">
                 <option value="${product.id}">${product.name }<option>
           </c:forEach>
      </select>
      <button type="submit">Create</button>
</form:form>
</body>
</html>