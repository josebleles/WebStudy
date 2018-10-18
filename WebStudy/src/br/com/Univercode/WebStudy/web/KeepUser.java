package br.com.Univercode.WebStudy.web;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.Univercode.WebStudy.controller.UserController;
import br.com.Univercode.WebStudy.dao.UserDAO;
import br.com.Univercode.WebStudy.domain.User;

@WebServlet(urlPatterns="/teacher/users")
public class KeepUser extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = new User(req.getParameter("name"),
				req.getParameter("email"),req.getParameter("password")
				,UserDAO.getTypeUser(req.getParameter("type")));
		if(!req.getParameter("id").equals("-1")){
			user.setId(Integer.parseInt(req.getParameter("id")));
			new UserController().update(user);
		}else{
			new UserController().save(user);
		}
				
		resp.sendRedirect("users");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("list", new UserController().listAll());
		String action;
		if((action = req.getParameter("action"))!= null){
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println(id);
			if(action.equals("remove")){
				new UserController().remove(id);
				req.getRequestDispatcher("users.jsp").forward(req, resp);
			}else{
				req.setAttribute("toEdit", new UserController().findById(id));
				req.getRequestDispatcher("users.jsp").forward(req, resp);
			}
		}else{
			req.getRequestDispatcher("users.jsp").forward(req, resp);
		}
	}

}
