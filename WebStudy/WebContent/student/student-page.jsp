<!DOCTYPE html>
<%@page import="br.com.Univercode.WebStudy.domain.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome at Tasks</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<%User student = (User)request.getSession().getAttribute("user"); %>

	<nav
		class="navbar navbar-expand-lg navbar-light bg-light justify-content-end">
		<form action="../logout" method="post" class="form-inline">
			<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">logout</button>

		</form>
	</nav>
	<div class="container" style="height: 100%;">
		<h1 class="display-3" align="center">
			Welcome,
			<%out.print(student.getName()); %>
		</h1>
		<h2 class="display-4" align="center">did you have 0 works to do</h2>

	</div>
	<text id="direitos" style="float:right;"> Todos os direitos
	reservados a <a href="http://www.univercode.com.br" target="_blank">
		Univercode ® </a> 2017-2018 </text>
</body>
</html>