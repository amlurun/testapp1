$(function(){
	
	// container is the DOM element;
	// userText is the textbox
	
	var first = $("#first")
		second = $("#second")
		answer = $('#answer'); 
	
	// Bind events
	userText.click(function () {
		
	  userText.val("");
	  
	}).bind('keypress',function(e){
		
		if(e.keyCode == 13){
			
			// The return key was pressed
			
			first.shuffleLetters({
				"text": answer.val()
			});
			
			answer.val("");
		}

	}).hide();
	
});

