<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Anna's Big Math</title>
	<link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body onload="setNums();">

<script type="text/javascript">
    
    var numCorrect = 0;
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="random.js"></script>
<script type="text/javascript" src="validate.js"></script>
<script type="text/javascript" src="jquery.shuffleLetters.js"></script>
<form action="" onsubmit="return validate()">
<!--  
<div id="countSection">
	<p id="countTitle">Count</p>
	<p id="count"></p>
	<p id="countHex"></p>
	<p id="countBinary"></p>
	<p id="countSquares"></p>
	<p id="countFib"></p>
</div>
 -->
<div id="equation">
	<span id="operands">
		<span id="first"></span>
		<br/>
		<span id="bottom_line">
			<span id="operator"></span>
			<span id="second"></span>
		</span>
		<br/>
		<input id="math_answer" type="text"/>
		
	</span>
</div>
<div id="conclusion">
	<span id="correct"></span>
</div>
</form>

</body>
</html>