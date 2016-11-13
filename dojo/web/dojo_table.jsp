<html>
	<head>
		<title>My Company Email Client</title>
		<link rel='stylesheet' href='css/style.css'>
		<script type="text/javascript" src="js/dojo/dojo.js" djConfig="isDebug: true"></script>
		<script type="text/javascript">
			//dojo.registerModulePath("custom","../../custom");
			dojo.require("custom.javaworld.Email");
			
			dojo.addOnLoad(custom.javaworld.Email.displayEmails);
		</script>
	</head>	
	<body class="tundra">
		<table border="1" bordercolor="green" width="100%" height="100%">
			<tr height="10%">
				<td colspan="2">Header</td>
			</tr>
			<tr >
				<td width="20%" id="sidemenu">
					<table>
						<tr><td><a href="javascript:custom.javaworld.Email.displayEmails();">Refresh</a></td></tr>
						<tr><td><a href="javascript:custom.javaworld.Email.composeEmails();">Compose Messages</a></td></tr>
					</table>
				</td>
				<td width="80%" id="body" align="top" valign="top">
					Getting emails
				</td>
			</tr>
			<tr height="5%">
				<td colspan="2">Footer</td>
			</tr>

		</table>
		<div id="body">
		</div>
	</body>
</html>	
