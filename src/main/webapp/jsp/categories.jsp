<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<%--@elvariable id="quote" type="kickstarter.entities.Quote>"--%>
<body>
Your inspiring quote, sir: <br/>
<c:out value="${quote.getQuoteString}"/>

</body>
</html>
