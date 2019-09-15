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
    <title>Category</title>
</head>
<body>
Category
<form action="/category" method="post">
    <input type="text" name="categoryName">
    <button>save</button>
</form>
<c:forEach var="category" items="${categories}">
    ${category.id} ${category.name}
    <a href="/category/${category.id}">delete</a>
    <br>
</c:forEach>
</body>
</html>
