package edu.poly.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.SessionUtils;
import edu.poly.entity.User;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/admin/*")
public class AuthFilter implements javax.servlet.Filter {

  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(SessionUtils.isLogin((HttpServletRequest) request)==true) {
			request.setAttribute("isLogin", SessionUtils.isLogin((HttpServletRequest) request));
			chain.doFilter(request, response);
		}else {
			HttpServletResponse httpResponse=(HttpServletResponse) response;
//			httpResponse.sendRedirect("/Login");
			HttpServletRequest request2=(HttpServletRequest) request;
			request2.getRequestDispatcher("/Login").forward(request, response);
		}	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
