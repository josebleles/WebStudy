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

@WebFilter(urlPatterns = { "/student/*" })
public class StudentFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String accessUri = request.getRequestURI(); // Uri access
		System.out.println("User: not specified accessing " + accessUri);
		HttpServletResponse response = (HttpServletResponse) rep;
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			if (!user.getType().equals(TypeUser.STUDENT)) {
				response.sendRedirect("/Tasks/index.jsp");
			}
		} else {
			response.sendRedirect("/Tasks/index.jsp");
		}
		chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
