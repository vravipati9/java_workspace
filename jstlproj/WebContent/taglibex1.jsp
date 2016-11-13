<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set value="Cowboy" var="userLevel" scope="request"></c:set>
<c:out value="${userLevel}"></c:out>
<a href="processJstl3.jsp"> Click this Link ...</a>

<br><br>
Iterating over PetMap
<c:set property="dogName" value="Tommy" target="${PetMap }"></c:set>
<c:forEach items="{Petmap}" var="pets">
	<c:out value="{pets}"></c:out>
</c:forEach>
</body>
</html>