<!DOCTYPE html>
<%@page import="br.com.Univercode.WebStudy.domain.Question"%>
<%@page import="br.com.Univercode.WebStudy.controller.UserController"%>
<%@page import="br.com.Univercode.WebStudy.domain.User"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<title>WebStudy | teacher</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<script src="../js/bootstrap.min.js"></script>
<style>
#content {
	max-height: 100px;
}
#anwser {
	max-height: 100px;
	min-height: 40px;
	height: 40px;
}
#radio {
	position:relative;
	top:25%;
	left:100%;
/* 	max-height: 100px; */
/* 	min-height: 40px; */
/* 	height: 40px; */
}

#lupa {
	
}
</style>
</head>
<body>

	<nav
		class="navbar navbar-expand-lg navbar-light bg-light justify-content-end">
		<a href='teacher-page.jsp'>
			<button class="btn btn-outline-info my-2 my-sm-0" type="submit">home</button>
		</a>
		<form action="questions.jsp" method="get" class="form-inline">
			<button class="btn btn-info my-2 my-sm-0" type="submit">Questions</button>

		</form>
		<br>
		<form action="users" method="get" class="form-inline">
			<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Users</button>

		</form>
		<br>

		<form action="../logout" method="post" class="form-inline">
			<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log-out</button>

		</form>


	</nav>
	<div class="content">

		<h1 class="display-3" align="center">Questions page</h1>
		<br> <br>
		<div class="row" style="margin-left: 8%;">
			<div class="col-sm-6">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Teacher</th>
							<th>Content</th>
							<th>Type</th>
							<th>Matter</th>

							<th>edit</th>
							<th>remove</th>
						</tr>
					</thead>
					<tbody>
						<%
    		/*ArrayList<User> users = new UserControler().ListAll();
    		for(User user : users){
    			out.println("<tr> "
        		        +"<td>"+user.getName()+"</td>"
        		        +"<td>"+user.getLogin()+"</td>"
        		        +"<td>"+user.getType().toString()+"</td>"
        		        +"<td>"+user.getType().toString()+"</td>"
        		        +"<td> <a href='register?id="+user.getId()+"&action=edit'> <img src='../img/edit.png' width='25px' height'25px'> </a> </td>"
        		        +"<td> <a href='register?id="+user.getId()+"&action=remove'> <img src='../img/delete.png' width='25px' height'25px'> </a> </td>"
        		      +"</tr>");
    		}*/
    		out.println("<tr> "
    		        +"<td> Erico </td>"
    		        +"<td> O que é um web service ? </td>"
    		        +"<td> Alternative</td>"
    		        +"<td> Java web</td>"
    		        +"<td> <img src='../img/edit.png' width='25px' height='25px'> </td>"
    		        +"<td> <img src='../img/delete.png' width='25px' height='25px'> </td>"
    		      +"</tr>");
    		
    	%>
					</tbody>
				</table>
			</div>
			<div class="col-sm-5">
				<div class="row justify-content-center">
					<form action="questions" method="POST">
						<% 	Question toEdit = null;
					boolean isEditable = false;
					if(isEditable = (request.getAttribute("toEdit") != null)){
						toEdit = (Question)request.getAttribute("toEdit");
						out.print("<input type='hidden' name='id' value='"+toEdit.getId()+"'>");
					} 
				%>
					<div id="alternativa">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-5">
									<label>Matter</label> <input type="text" name="disciple"
										class="form-control" placeholder="search matter"
										style="float: left; width: 80%;" required> <img
										src='../img/search.png' width='25px' height='25px'
										style="float: left;">
								</div>
								<div class="col-sm-6">
									<label>type question:</label> <select name="type"
										class="form-control" required>
										<option value="">select one</option>
										<option value="alternative">alternative</option>
										<option value="dissertative">dissertative</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-5">
									<label>level question:</label> <select name="level"
										class="form-control" required>
										<option value="">select one</option>
										<option value="EASY">easy</option>
										<option value="NORMAL">normal</option>
										<option value="HARD">hard</option>
									</select>
									
								</div>
								<div class="col-sm-5">
									<label>theme question</label> <input type="text" name="theme"
										class="form-control" placeholder="search matter"
										style="float: left; width: 80%;" required> <img
										src='../img/search.png' width='25px' height='25px'
										style="float: left;">
								</div>
							</div>
							<label for="exampleInputEmail1">Content Question</label>
							<textarea id="content" name="content" class="form-control"
								required> </textarea>
							<small class="form-text text-muted">your questions have
								to be context with the Matter.</small>
						</div>
						<div class="form-group">
							<label>anwsers</label>
							<div class="row">
								<div class="col-sm-1">
									<input id="radio" type="radio" name="certa" value="1">
								</div>
								<div class="col-sm-11">
									<textarea id="anwser" name="anwswer1" class="form-control"
									required></textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-1">
									<input id="radio" type="radio" name="certa" value="2">
								</div>
								<div class="col-sm-11">
									<textarea id="anwser" name="anwswer2" class="form-control"
									required></textarea>
								</div>
							</div>
						</div>		
						<div class="form-group">
							<div class="row">
								<div class="col-sm-1">
									<input id="radio" type="radio" name="certa" value="3">
								</div>
								<div class="col-sm-11">
									<textarea id="anwser" name="anwswer3" class="form-control"
									required></textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-1">
									<input id="radio" type="radio" name="certa" value="4">
								</div>
								<div class="col-sm-11">
									<textarea id="anwser" name="anwswer4" class="form-control"
									required></textarea>
								</div>
							</div>
							<small class="form-text text-muted">you have
								to select a right anwser.</small>
						</div>
					</div>
						
					<div class="row justify-content-end">
							<button type="submit" class="btn btn-primary col-sm-e bootstr3">Register</button>
					<a href="questions.jsp"><input type="button"
						class="btn btn-outline-danger" value="CLEAR"> </a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>