<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<%--@elvariable id="listOfCategories" type="java.utils.List<Category>"--%>
<body>
Your inspiring quote, sir: <br/>
<c:out value="${quote}"/>
<ul>
<c:forEach var="category" items="${listOfCategories}">
    <c:url value="/category" var="categoryURL">
        <c:param name="category-id" value="${category.getId()}"/>
    </c:url>
    <li>
        <h2>
            <a href="${categoryURL}">${category.getName()}</a>
        </h2>
    </li>
</c:forEach>
</ul>

</body>
</html>
