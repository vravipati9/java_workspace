
<%@page import="com.javaworld.email.EmailForm"%><script type="text/javascript">
	dojo.registerModulePath("custom","../custom");
	dojo.require("custom.javaworld.Email");

</script>
<%
	EmailForm emailForm = (EmailForm)request.getAttribute("emailForm");
	String emailTo = "";
	String emailSubject ="";
	String emailBody ="";
	if(emailForm != null){
		 emailTo = emailForm.getEmailTo();
		 emailSubject = emailForm.getEmailSubject();
		 emailBody = emailForm.getEmailBody();
	}
%>
<form id="emailForm">
	<table>
		<tr>
			<td width="10%">To</td>
			<td><input name="emailTo" type="text" value="<%=emailTo %>" /></td>
		</tr>
			<tr>
			<td width="10%">Subject</td>
			<td><input name="emailSubject" type="text" value="<%=emailSubject %>"  /></td>
		</tr>
		<tr>
			<td colspan="2"><textarea name="emailBody" cols="100" rows="10" ><%=emailBody %></textarea></td>
		</tr>
		<tr>
			<td ><input type="submit" value="Send" onclick="return custom.javaworld.Email.sendEmail();" />  </td>
			<td ><input type="reset" value="Discard" />  </td>
		</tr>

	</table>
</form>