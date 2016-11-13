dojo.provide("custom.javaworld.Worker");

dojo.declare("custom.javaworld.Worker",null,{
    firstName: "",
    lastName: "",
    constructor: function(fName, lName){
    console.debug("Constructor of com.javaworld.Worker called");
    this.firstName = fName;
    this.lastName = lName;
	},
                
    work: function(){
        console.log("Worker method called in Worker class");
        //alert("asdfasdf");
    }
});

