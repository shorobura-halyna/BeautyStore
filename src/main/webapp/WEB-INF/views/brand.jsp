<%--
  Created by IntelliJ IDEA.
  User: halyna
  Date: 15.09.19
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Brand</title>
</head>
<body>
Brand
<form action="/brand" method="post">
    <input type="text" name="brandName">
    <button>save</button>
</form>
<c:forEach var="brand" items="${brands}">
    ${brand.id} ${brand.name}
    <a href="/brand/${brand.id}">delete</a>
    <br>
</c:forEach>
</body>
</html>
