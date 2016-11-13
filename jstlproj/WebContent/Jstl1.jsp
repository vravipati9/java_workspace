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
	<b>Iterating elements by using Scriptlet</b><br>

	<% 
	
	String[] strArr = (String[])request.getAttribute("musicArray");
		
		for (String str : strArr) {
			out.print(str+",		");
		}
		String hrefLink1 = (String)request.getAttribute("hrefLink"); 
	%>
	<br><b>${hrefLink}</b><br>
	<%=hrefLink1 %>
	<br><b>Iterating elements by using Jsp taglib's</b><br>
	<c:forEach var="musArr" items="${musicArray }" varStatus="musicLoopCount">
		Count: ${musicLoopCount.count}
		<c:out value="${musArr}"></c:out>
	</c:forEach>
	
	<br><br><b>:Nested forEach:</b><br>
	<c:forEach var="movies" items="${movieList}">
		
		<c:forEach var="movie" items="${movies}">
			<tr>
				<td><c:out value="${movie }"></c:out></td>
			</tr>
		</c:forEach>
		<br>
	</c:forEach>
	
</body>
</html>