//ITWorker Class depends on Worker class. Hence, Worker class is require for ITWorker.
dojo.provide("custom.javaworld.ITWorker");
dojo.require("custom.javaworld.Worker");

dojo.declare("custom.javaworld.ITWorker",custom.javaworld.Worker,{
    constructor: function(fName, lName){
        console.debug("Constructor of com.javaworld.ITWorker");
    },
    work: function(){
        this.inherited(arguments);
        console.log("Writing Code in IT Worker class");
    }
});
