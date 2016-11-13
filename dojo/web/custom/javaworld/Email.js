dojo.provide("custom.javaworld.Email");

custom.javaworld.Email ={
		displayEmails: function(){
			dojo.xhrGet({
				url: "displayEmails",
				load: function(data, ioargs){
				console.log("-------Response from Server----"+data);
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
		console.log("---Query by tag. All the table elements in the document----");	//
		console.log(dojo.query("table"));
		
		console.log("---Query by class. All the elements with class==header---");
	    console.log(dojo.query(".header"));
	    
	    console.log("---Query by id. All the elements with id==inbox---");
	    console.log(dojo.query("#inbox"));
	    
	    console.log("---returns all the <table> elements for which class==inbox ---");
	    console.log(dojo.query("table.inbox"));
	    
	    console.log("---First find the inbox element and then return all the tr elements which are children of tbody---");
	    var rowList =dojo.query("tbody tr","inbox");
	    
	    console.log("---to find out all the <td> elements with id==sidemenu");
	    dojo.query("td#sidemenu");
	    
	    console.log("to get a list of the first children of all table nodes.");
	    dojo.query("table:first-child");
		
		var nodeCount = 0;
		dojo.query(".row","inbox").filter(
		   function(thisRow) {
		      return (nodeCount++) % 2 == 0;
		   }
		).style("backgroundColor",'lightBlue');
		console.log("total rows by selecting with dojo.query>>>>>>>>"+(dojo.query(".row","inbox")));
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

