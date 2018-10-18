<!DOCTYPE html>
<%@page import="br.com.Univercode.WebStudy.domain.TypeUser"%>
<%@page import="br.com.Univercode.WebStudy.controller.UserController"%>
<%@page import="br.com.Univercode.WebStudy.domain.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>WebStudy | teacher</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<script src="../js/bootstrap.min.js"></script>
</head>
<body>

	<nav
		class="navbar navbar-expand-lg navbar-light bg-light justify-content-end">
		<a href='teacher-page.jsp'>
			<button class="btn btn-outline-info my-2 my-sm-0" type="submit">home</button>
		</a>
		<form action="questions.jsp" method="post" class="form-inline">
			<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Questions</button>

		</form>
		<br>
		<form action="users" method="post" class="form-inline">
			<button class="btn btn-info my-2 my-sm-0" type="submit">Users</button>

		</form>
		<br>

		<form action="../logout" method="post" class="form-inline">
			<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log-out</button>

		</form>


	</nav>
	<div class="content">

		<h1 class="display-3" align="center">Register page</h1>
		<br> <br>
		<div class="row" style="margin-left: 10%;">
			<div class="col-sm-6">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Acess</th>
							<th>edit</th>
							<th>remove</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${list}">
							<tr>
								<td>${user.name}</td>
								<td>${user.login}</td>
								<td>${user.type}</td>
								<td><a href='users?id=${user.id}&action=edit'> <img
										src='../img/edit.png' width='25px' height='25px'>
								</a></td>
								<td><a href='users?id=${user.id}&action=remove'> <img
										src='../img/delete.png' width='25px' height='25px'>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-sm-5">
				<div class="row justify-content-center">
					<form action="users" method="POST">
						<% 
				User toEdit = null;
				boolean isEditable = false;
				if(isEditable = (request.getAttribute("toEdit") != null)){
					toEdit = (User)request.getAttribute("toEdit");
					out.print("<input type='hidden' name='id' value='"+toEdit.getId()+"'>");
				} 
				%>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-5">
									<label>Name</label> <input type="text" name="name"
										value="<% if(isEditable) out.print(toEdit.getName()); %>"
										class="form-control" placeholder="Enter name" required>
								</div>
								<div class="col-sm-5">
									<label for="sel1">Select list:</label> <select name="type"
										class="form-control" id="sel1" required>
										<option value="">Type Acess</option>
										<option value="TEACHER"
											<% if(isEditable && toEdit.getType() == TypeUser.TEACHER) out.print("selected='selected'"); %>>teacher</option>
										<option value="STUDENT"
											<% if(isEditable && toEdit.getType() == TypeUser.STUDENT) out.print("selected='selected'"); %>>student</option>
									</select>
								</div>
							</div>
							<label for="exampleInputEmail1">Email address</label> <input
								type="email" name="email" class="form-control"
								aria-describedby="emailHelp"
								value="<% if(isEditable) out.print(toEdit.getLogin()); %>"
								placeholder="Enter email" required> <small
								id="emailHelp" class="form-text text-muted">We'll never
								share your email with anyone else.</small>

						</div>
						<div class="form-group">

							<label for="exampleInputPassword1">Password</label> <input
								type="password" name="password" class="form-control"
								id="exampleInputPassword1" placeholder="Password"
								value="<% if(isEditable) out.print(toEdit.getPassword()); %>"
								required> <label for="exampleInputPassword1">Confirm
								Password</label> <input type="password" name="passwordc"
								value="<% if(isEditable) out.print(toEdit.getPassword()); %>"
								class="form-control" id="exampleInputPassword1"
								placeholder="Confirm Password" required>
						</div>
						<div class="row justify-content-end">
							<button type="submit" class="btn btn-primary col-sm-3">
								<% out.print((isEditable)? "Edit" : "Register"); %>
							</button>
							<p style="color: white">&nbsp;</p>
					</form>
					<a href="users"><input type="button"
						class="btn btn-outline-danger" value="Cancel"> </a>
				</div>

			</div>
		</div>
	</div>


	</div>
</body>
</html>