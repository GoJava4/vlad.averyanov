<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category <c:out value="${category.name}"/></title>
</head>
<body>
<jsp:include page="menu.jsp"/>
Projects of <c:out value="${category.name}"/>
<ul>
    <c:forEach var="project" items="${projectList}">
        <c:url value="/project" var="projectURL">
            <c:param name="projectId" value="${project.id}"/>
        </c:url>
        <li>
            <h3>
                <a href="${projectURL}">${project.name}</a>
                <br/> <c:out value="${project.shortDescription}"/>
            </h3>
        </li>
    </c:forEach>
</ul>
</body>
</html>