<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page not found</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h2>404. Sorry, there is no such page.</h2>

<h2>But hey! Look what we've got for you.</h2>
<img src="<c:url value="/resources/img/error-404.jpg"/>"/>
</body>
</html>
