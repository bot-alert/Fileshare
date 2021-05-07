<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="cs/homepage.css">
</head>
<body
	style="background-image: radial-gradient(circle at top right, #9600ff, #aebaf8);">
	<div id="add_file_box" class="box1"
		style="background-image: url(/img/plus.png);background-size: cover;">
		<p id="send">Click to add file</p>
		<form id="form" action="/addfile" method="post">
		<input id ="save_file" type="file" placeholder="file">
	
		</form>
		
	</div>
	<div class="box">
		<p id="recive">Receive</p>
		<form class="form" action="/send" method="post">
			<input id="key" type="text" name="key" placeholder="Secret Key" /> <br>
			<button type="submit">Submit</button>
		</form>

	</div>

	<script src="js/homepage.js"></script>

</body>
</html>