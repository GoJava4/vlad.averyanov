<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--@elvariable id="project" type="kickstarter.entities.Project"--%>
<head>
    <title>Category <c:out value="${project.name}"/></title>
</head>
<body>
Project <c:out value="${project.name}"/>
<h3>
    shortDescription: <c:out value="${project.shortDescription}"/> <br/>
    daysToGo(): <c:out value="${project.daysToGo()}"/> <br/>
    moneyGoal: <c:out value="${project.moneyGoal}"/> <br/>
    pledged: <c:out value="${project.pledged}"/> <br/>
    addingDate: <c:out value="${project.addingDate}"/> <br/>
    fullDescription: <c:out value="${project.fullDescription}"/> <br/>
</h3>
</body>
</html>
