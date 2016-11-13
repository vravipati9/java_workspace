<!--
  Shows how to use standard tags (JSTL), We can use implict variables
like param,header,cookie,pageScope,requestScope,sessionScope,applicationScope,pageContext
-->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<HTML>
<HEAD>
<TITLE>Example on JSTL Coretags</TITLE>
</HEAD>
<BODY BGCOLOR="#FFFFFF">
<c:out value="user agent ${header['User-Agent']}"/>
<br><br>
<c:if test="${param.carSelect =='Performance' }">
	Car Choosen is performence.
</c:if>
<br><br><strong>By Using when/choose</strong>
<c:choose>
	<c:when test="${param.carSelect =='Performance' }">\
		Car Choosen is performence.
	</c:when>

	<c:when test="${param.carSelect =='Safety' }">\
		Car Choosen is Safety.
	</c:when>
	
	<c:otherwise>
		Nothing is Best.
	</c:otherwise>
	
</c:choose>

<br>
<c:out value="${userLevel }"></c:out>

</BODY>
</HTML>
