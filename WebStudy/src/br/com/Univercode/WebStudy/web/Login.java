package br.com.Univercode.WebStudy.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.Univercode.WebStudy.controller.UserController;
import br.com.Univercode.WebStudy.domain.TypeUser;
import br.com.Univercode.WebStudy.domain.User;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = new User(req.getParameter("email"),req.getParameter("password"));
		ArrayList<User> allUsers = new UserController().listAll();
		boolean iFound = false;
		for (User user2 : allUsers) {
			if(user2.isSame(user)){
				iFound = true;
				req.getSession().setAttribute("user", user2);
				resp.sendRedirect((user2.getType() == TypeUser.TEACHER)? "teacher/teacher-page.jsp" : "student/student-page.jsp");
			}
		}
		if (!iFound) {
			req.getSession().removeAttribute("user");	
			resp.sendRedirect("index.html");
		}
		
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	
}
