package br.com.Univercode.WebStudy.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.Univercode.WebStudy.controller.UserController;
import br.com.Univercode.WebStudy.dao.UserDAO;
import br.com.Univercode.WebStudy.domain.Anwser;
import br.com.Univercode.WebStudy.domain.Question;
import br.com.Univercode.WebStudy.domain.User;

@WebServlet(urlPatterns="/professor/questions")
public class KeepQuestion extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<Anwser> anwsers = new ArrayList<>();
		int alternativaCerta = Integer.parseInt(req.getParameter("certo"));
		for (int i = 1; i < 5; i++) {
			anwsers.add(new Anwser(req.getParameter("anwser"+i),(alternativaCerta == i)));
		}
		Question question = new Question(req.getParameter("contest"), req.getParameter("disciple"), req.getParameter("theme"), req.getParameter("type"), req.getParameter("level"), anwsers);
		if(!req.getParameter("id").equals("-1")){
			user.setId(Integer.parseInt(req.getParameter("id")));
			new UserController().update(user);
		}else{
			new UserController().save(user);
		}
				
		resp.sendRedirect("questions");

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
				req.getRequestDispatcher("questions.jsp").forward(req, resp);
			}else{
				req.setAttribute("toEdit", new UserController().findById(id));
				req.getRequestDispatcher("questions.jsp").forward(req, resp);
			}
		}else{
			req.getRequestDispatcher("questions.jsp").forward(req, resp);
		}
	}

}
