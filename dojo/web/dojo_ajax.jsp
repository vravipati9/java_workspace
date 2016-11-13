<html>
	<head>
		<title>My Company Email Client</title>
		<link rel='stylesheet' href='css/style.css'>
		<script type="text/javascript" src="js/dojo/dojo.js" djConfig="isDebug: true"></script>
		<script type="text/javascript">
			dojo.registerModulePath("custom","../../custom");
			dojo.require("custom.javaworld.Email");
			/*
			dojo.connect() takes 5 arguments.
				obj: The source object for the event function. If you want to listen for the DOM event, this should be the DOM node. 
					If you want to connect to another function, this argument should be object that function is defined in. This argument can be null.
				event: The name of the event function. For a DOM event this could be something like onclick. For a function event this would be name of the function that you want to listen for.
				context: The object that this method will receive as this.
				method: Name or function reference of the JavaScript function that will be called to handle the event.
				dontFix: If obj is a DOM node, set dontFix to true to prevent delegation of this connection to the DOM event manager.*/
		 	dojo.connect(dojo,"xhrPost",null,function(args){
			 	console.log("xhrPost connected");
				console.dir(args);
		 	});
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
