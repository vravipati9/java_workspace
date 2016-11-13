<%@page import="java.util.ArrayList"%>
<%@page import="com.javaworld.email.EmailForm"%>
<link rel='stylesheet' href='css/style.css'>


<%@page import="java.text.SimpleDateFormat"%>
<table cellspacing="2" cellpadding="3" border="1" id="inbox">
	<tr class="header" >
		<th>From</th>
		<th>Subject</th>
		<th>Date</th>
	</tr>
<%
	ArrayList emailList =(ArrayList)request.getAttribute("emailList");
	for(int i =0 ; i < emailList.size() ;i++){
		EmailForm email = (EmailForm)emailList.get(i);
		SimpleDateFormat sd = new SimpleDateFormat("mm/dd/yyyy");
%>
	<tr class="row" id="<%=email.getEmailId()  %>" >
		<td width="15%"><%=email.getEmailTo() %></td>
		<td width="75%"><%=email.getEmailSubject() %></td>
		<td width="10%"><%=sd.format(email.getEmailDate()) %></td>
	</tr>
<%
	}
%>	
</table>

