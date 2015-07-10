<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <security:authorize access="!isAuthenticated()">
        <p><a href="<c:url value="/login"/>" role="button">Log in</a></p>
        <button type="submit"
                formmethod="get" formaction="/servlet/user"> Sign up
        </button>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
        <p><a href="<c:url value="/logout"/>" role="button">Log
            out</a></p>
    </security:authorize>
</div>