<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding news manually</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/news.css"/>">
</head>
<body>
<h1><spring:message code="news.add" /></h1>

<form:form action="create" method="post" modelAttribute="news" enctype="multipart/form-data">
    <form:hidden path = "id" />
    <form:label path="head">
        <spring:message code="label.enter.head" />*
    </form:label>
    <form:input path="head" />
    <div>
        <form:label path="body">
            <spring:message code="label.enter.body" />*
        </form:label>
    </div>
    <div>
        <form:textarea cols="100" rows="20" path="body" />
    </div>
    <div>
        <spring:message code="label.choose.pic" />
    </div>
    <input type="file" name="file" accept=<spring:message code="picture.load.filter"/>/>
    <div>
        <spring:message code="label.required" />
    </div>
    <button type="submit"><spring:message code="button.submit" /></button>
</form:form>
</body>
</html>
