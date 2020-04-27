<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set value="${80}" var="targetScore" scope="session"></c:set>
<c:out value="${targetScore}"></c:out><br>
<%-- <c:if test="${targetScore>70}">
	<p>Your score is Awesome :<c:out value="${targetScore}"></c:out></p>
</c:if><br> 
<c:choose>
<c:when test="${targetScore <80}">
	A Grade
</c:when>
<c:when test="${targetScore >80}">
	B Grade	
</c:when>
<c:otherwise>
	OtherWise
</c:otherwise>
</c:choose>


--%>
<c:forEach begin="1" end="3">
<c:out value="${i} "></c:out>
</c:forEach>


<c:remove  var="targetScore"></c:remove>
<br>After Removing : <c:out value="${targetScore}"></c:out>
</body>
</html>