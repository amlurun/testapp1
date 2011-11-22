function IsNumeric(n){
    return !isNaN(n);
} 

function setNums() {
	document.getElementById('math_answer').value="";
	document.getElementById("math_answer").focus();
	
//	console.debug("setNums ")
	var first = $("#first")
	var first_num = getRandom(0, 0.0, 10.0).toString();
	first.shuffleLetters({
		"text": first_num
	});
	
	var second = $("#second")
	var second_num = getRandom(0, 0.0, 10.0).toString();
	second.shuffleLetters({
		"text": second_num
	});
	
	//$("#first").text(getRandom(0, 0.0, 10.0));
	$("#operator").text(getRandom(0, 1.0, 2.0) == 1 ? "+" : "-");
	//$("#second").text(getRandom(0, 0.0, 10.0));
	
}

function getRandom(start, numLow, numHigh) {
	
    //var numLow = $("#lownumber").val();
    //var numHigh = $("#highnumber").val();
    //var numLow = 0.0;
   // var numHigh = 10.0;
    
    var adjustedHigh = (parseFloat(numHigh) - parseFloat(numLow)) + 1;
    
    var numRand = Math.floor(Math.random()*adjustedHigh) + parseFloat(numLow);
    if (start == 10) {
    	return numRand;
    }
    	

    return numRand;
}
