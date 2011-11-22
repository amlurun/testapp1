function validate() {
	var first = document.getElementById("first").innerHTML
	var second = document.getElementById("second").innerHTML
	var operator = document.getElementById("operator").innerHTML
	var math_answer = document.getElementById("math_answer").value
	
	var valid = doEquation(first, second, operator, math_answer);
	if (valid) {
		document.getElementById("correct").innerHTML = "Correct!"
		numCorrect = numCorrect + 1;
		$("#equation").fadeOut("slow");
		
		$("#count").text(numCorrect);
		$("#countHex").text(numCorrect.toString(16));
		$("#countBinary").text(numCorrect.toString(2));
		$("#countSquares").text(Math.pow(2, numCorrect));
		$("#countFib").text(numCorrect.toString(2));
		
		console.debug("numCorrect " + numCorrect)
		$("#equation").fadeIn(100, setNums());
		document.getElementById("correct").innerHTML = ""
		
	} else {
		document.getElementById("correct").innerHTML = "Sorry!"
	}
	
	return false;
}

function doEquation(first, second, operator, answer) {
	if (operator == "+") {
		var additionResult = parseInt(first) + parseInt(second)
		return additionResult == parseInt(answer)
	} else if (operator == "-") {
		var additionResult = parseInt(first) - parseInt(second)
		return additionResult == parseInt(answer)
	} 
	
	return false; // error handling
}

function returnValue(value) {
	return value;
}
