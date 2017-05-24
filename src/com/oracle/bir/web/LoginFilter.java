package com.oracle.bir.web;

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
import javax.servlet.http.HttpSession;

import com.oracle.bir.domain.Admin;

@WebFilter(filterName="LoginFilter", urlPatterns={"/admin/*"})
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
	
		String requestURI = req.getRequestURI().substring(req.getRequestURI().indexOf("/admin/"));
		System.out.println("======"+requestURI);
		if (requestURI.indexOf("Login") == -1) {
			Admin admin = (Admin) session.getAttribute("adminUser");
			if (admin == null) {
				session.setAttribute("login.next", requestURI);
				
				String loginPage = req.getContextPath() + "/admin/" + "Login.jsp";
				((HttpServletResponse)response).sendRedirect(loginPage);
				System.out.println("======"+loginPage);
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
