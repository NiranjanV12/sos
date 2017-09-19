<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<html>
<head>
<title>Spittr</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>


<body>
<h1>Register</h1>
<sf:form method="POST" commandName="spitter">
<ct:forEach items="${spittleList}" var="aa">
<div>
<strong>id</strong> = ${aa.id}
<strong>name </strong>= ${aa.message}
</div>
</ct:forEach>

</sf:form>
</body>
</html>