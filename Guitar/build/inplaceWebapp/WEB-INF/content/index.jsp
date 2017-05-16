<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
	<title>Guitar Sale</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
		<script type="text/javascript" src="js/search.js"></script>
</head>
<body>
	<header id="header"> 
		<div class="welcomes">
		<span>Guitar Sale</span> <span>Welcome
		here to choose the guitar suitable you like</span>
		</div>
	</header>
	<section id="content">
	<div id="search-form">
		<form action="search">
			<ul>
				<li><label for="builder">Builder:</label> 
					<input type="input" name="builder" placeholder="builder" id="builder"></li>

				<li><label for="model">Model:</label> 
					<input type="input" name="model" placeholder="model" id="model"></li>

				<li><label for="type">Type:</label> <input type="input"
					name="type" placeholder="type" id="type"></li>

				<li><label for="backWood">Back Wood:</label> <input
					type="input" name="backWood" placeholder="back wood" id="backWood"></li>
				<li><label for="">Top Wood:</label> <input type="input"
					name="topWood" placeholder="top wood" id="topWood"></li>

			</ul>
			<input type="submit" name="submit" value="search">
		</form>
	</div>
	<div id="result-show">
		<h2>Results</h2>
		<table border="1">

			<thead>
				<tr>
					<td>serialNumber</td>
					<td>price</td>
					<td>builder</td>
					<td>model</td>
					<td>type</td>
					<td>backWood</td>
					<td>topWood</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${application.guitar.serialNumber}</td>
					<td>${application.guitar.price}</td>
					<td>${application.guitar.builder}</td>
					<td>${application.guitar.model}</td>
					<td>${application.guitar.type}</td>
					<td>${application.guitar.backWood}</td>
					<td>${application.guitar.topWood}</td>
				</tr>
			</tbody>

		</table>
	</div>
	</section>
</body>
</html>