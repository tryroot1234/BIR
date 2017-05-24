package com.oracle.bir.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="LogoutServlet", urlPatterns={"/logout.do"})
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 360741292210840335L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
//		System.out.println("=========session===========");
		if (session.getAttribute("adminUser") != null) {
//			System.out.println("=========remove===========");
			session.removeAttribute("adminUser");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		
	}

}
