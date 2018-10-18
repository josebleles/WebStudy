package br.com.Univercode.WebStudy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.Univercode.WebStudy.dao.MyConnection;

@WebServlet(urlPatterns="/teste")
public class Conection extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		Connection conn = MyConnection.getConnection();
		if(conn != null){
			writer.println("eh treta");
			MyConnection.closeConnection(conn);
		}else{
			writer.println("ih rapaz");
		}
		
	}

}
