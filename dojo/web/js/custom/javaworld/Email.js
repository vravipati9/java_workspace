dojo.provide("custom.javaworld.Email");

custom.javaworld.Email ={
		displayEmails: function(){
			dojo.xhrGet({
				url: "displayEmails",
				load: function(data, ioargs){
				console.log("Response from Server----"+data);
					dojo.byId("body").innerHTML = data;
					custom.javaworld.Email.decorateInbox();
				},
				error: function(error,ioargs){
					alert(error);
				}
			});
		},
		composeEmails: function(){
			console.log("Entering composeEmails()");
			dojo.xhrGet({
				url: "sendEmailForm.do",
				load: function(data, ioargs){
					dojo.byId("body").innerHTML = data;
				},
				error: function(error,ioargs){
					alert(error);
				}
				});
			console.log("Exiting composeEmails()");
		},
		sendEmail: function(){
			console.log("Entering sendEmail()");
			dojo.xhrPost({
				url: "sendEmail.do",
				form: "emailForm",
				load: function(data, ioargs){
					dojo.byId("body").innerHTML = data;
					custom.javaworld.Email.decorateInbox();
				},
				error: function(error,ioargs){
					alert(error);
				}
				});
			
			console.log("Exiting sendEmail()");
			return false;
	},
	decorateInbox: function(){
		console.log("====decorateInbox()======");
		var nodeCount = 0;
		
		/*  get all row classes from inbox id,
		 * <table cellspacing="2" cellpadding="3" border="1" id="inbox">
		 * 	<tr class = "row">
		 */
		dojo.query(".row","inbox").filter(
		   function(thisRow) {
		      return (nodeCount++) % 2 == 0;
		   }
		).style("backgroundColor",'lightBlue');
/*		dojo.query("a").forEach(function(item,index,array){
			item.removeAttribute('href');
			item.style.color='grey';
			console.log(index);
		});
		
		dojo.query("table").filter("#inbox").forEach(function(item,index,array){
			console.log("table");
		}); */
		

		dojo.query(".row","inbox").forEach(
		   function(thisRow) {
		      dojo.connect(thisRow,'onclick',function(event){
		    	  console.log("Got control in custom event handler");
		    	  console.log(event.target);
		    	  console.log(event.currentTarget);
		    	  var emailId = dojo.attr(event.currentTarget,"id");
		    	  dojo.xhrGet({
						url: "openEmail.do?emailId=" +emailId ,
						load: function(data, ioargs){
							dojo.byId("body").innerHTML = data;
						},
						error: function(error,ioargs){
							alert(error);
						}
						});
		      });
		   }
		)
		
	}
}

