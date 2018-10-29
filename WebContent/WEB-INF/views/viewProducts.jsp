<%@page isELIgnored="false" import="java.time.LocalDateTime"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%=LocalDateTime.now()%>
<br>
<h2>Product Details:</h2>
<c:if test="${products!=null}">
	<c:forEach items="${products}" var="product">
		<c:out value="${product}"></c:out>
	</c:forEach>
</c:if>
<c:if test="${products == null }">
	<c:out value="No product retrieved!"></c:out>
</c:if>
<br>
