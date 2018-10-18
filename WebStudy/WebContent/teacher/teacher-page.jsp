<!DOCTYPE html>
<%@page import="br.com.Univercode.WebStudy.domain.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>WebStudy | teacher</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<% User teacher = (User)request.getSession().getAttribute("user"); %>
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light justify-content-end">
		<a href='teacher-page.jsp'>
			<button class="btn btn-info my-2 my-sm-0" type="submit">home</button>
		</a>
		<form action="questions.jsp" method="post" class="form-inline">
			<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Questions</button>

		</form>
		<br> <a href="users">
			<button class="btn btn-outline-info my-2 my-sm-0">Users</button>

		</a> <br>

		<form action="../logout" method="post" class="form-inline">
			<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log-out</button>

		</form>


	</nav>
	<div class="container">
		<h1 class="display-3" align="center">
			Welcome,
			<% out.print(teacher.getName()); %>
		</h1>

	</div>
</body>
</html>
