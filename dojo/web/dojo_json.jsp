<html>
<body onLoad="onLoad();">
<head>
 <title>Example 1</title>
 

 <script language="javascript" src="js/dojo/dojo.js"></script>
 <script language="javascript">
  dojo.require("dojo.io.*");
  dojo.require("dojo.event.*");

  function onLoad() {
		/*
		dojo.connect() takes 5 arguments.
			obj: The source object for the event function. If you want to listen for the DOM event, this should be the DOM node. 
				If you want to connect to another function, this argument should be object that function is defined in. This argument can be null.
			event: The name of the event function. For a DOM event this could be something like onclick. 
					For a function event this would be name of the function that you want to listen for.
			context: The object that this method will receive as this.
			method: Name or function reference of the JavaScript function that will be called to handle the event.
			dontFix: If obj is a DOM node, set dontFix to true to prevent delegation of this connection to the DOM event manager.*/	  
   var buttonObj = document.getElementById("myButton");
   dojo.event.connect(buttonObj, "onclick",
          this, "onclick_myButton");
  }

  function onclick_myButton() {
   var bindArgs = {
    url: "welcome.jsp",
    error: function(type, data, evt){
     alert("An error occurred.");
    },
    load: function(type, data, evt){
     alert(data);
    },
    mimetype: "text/plain",
    formNode: document.getElementById("myForm")
   };
   dojo.io.bind(bindArgs);
  }
 </script>
</head>
<body>
<form id="myForm">
 <input type="text" name="name"/>
 <input type="button" id="myButton" value="Submit"/>
</form>
</body>
</html>