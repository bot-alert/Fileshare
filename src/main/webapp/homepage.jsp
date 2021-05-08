<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		style="background-image: url(/img/plus.png); background-size: cover;">
		<p id="send">Click to add file</p>
		<c:if test="${id != null}">
				<p style="color: blue" id="send"> <c:out value="${id}"/> </p>
				<script>
				const costumetext = document.getElementById("send");
				costumetext.innerHTML="Share this key to receive";
				
				</script>
			</c:if>
		<form id="form" action="/" method="post"
			enctype="multipart/form-data">
			<input id="save_file" type="file" placeholder="file" name="file_name">

		</form>

	</div>
	<div class="box">
		<p id="recive">Receive</p>
		<form class="form" action="/download" method="get">
			<input id="key" type="text" placeholder="Secret Key" /> <br>
			<button type="submit">Submit</button>
		</form>

	</div>

	<script src="js/homepage.js"></script>

</body>
</html>