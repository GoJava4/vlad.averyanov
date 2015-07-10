<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<%--@elvariable id="listOfCategories" type="java.utils.List<Category>"--%>
<body>
<jsp:include page="menu.jsp"/>
Your inspiring quote, sir: <br/>
<c:out value="${quote}"/>
<ul>
<c:forEach var="category" items="${listOfCategories}">
    <c:url value="/category/${category.id}" var="categoryURL">
        <%--<c:param name="categoryId" value="${category.id}"/>--%>
    </c:url>
    <li>
        <h2>
            <a href="${categoryURL}">${category.name}</a>
        </h2>
    </li>
</c:forEach>
</ul>

</body>
</html>
