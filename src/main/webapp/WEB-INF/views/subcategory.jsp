<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 15.09.19
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Subcategory</title>
</head>
<body>
Subcategory
<form action="/subcategory" method="post">
    <input type="text" name="subcategoryName">
    <select name="categoryId">
        <option>choose category</option>
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <button>save</button>
</form>
<c:forEach var="subcategory" items="${subcategories}">
    ${subcategory.id} ${subcategory.name} ${subcategory.category.name}
    <a href="/subcategory/${subcategory.id}">delete</a>
    <br>
</c:forEach>
</body>
</html>
