<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog-MD</title>
</head>
<body>
<h2>TEST/h2>

<c:forEach items="${données}" var="tactic">
	<p>
		<c:out value="${tactic}" />
	</p>
</c:forEach>

</body>
</html>
