package br.com.Univercode.WebStudy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.Univercode.WebStudy.domain.TypeUser;
import br.com.Univercode.WebStudy.domain.User;

@WebFilter(urlPatterns={"/professor/*"})
public class ProfessorFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String accessUri = request.getRequestURI();
		System.out.println("Professor: not specifield accessing "+accessUri);
		
		User user  = (User) request.getSession().getAttribute("user");
		HttpServletResponse response =
				(HttpServletResponse) res;
		if(user!=null){
			if(!user.getType().equals(TypeUser.TEACHER)){
				response.sendRedirect("/Tasks/index.jsp");
	
			}
		}else{
			response.sendRedirect("/Tasks/index.jsp");

		}
		chain.doFilter(req, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
