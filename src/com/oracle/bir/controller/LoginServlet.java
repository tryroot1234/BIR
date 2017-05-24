package com.oracle.bir.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.bir.Exception.LoginException;
import com.oracle.bir.domain.Admin;
import com.oracle.bir.service.LoginService;

@WebServlet(name="LoginServlet", urlPatterns={"/admin/admin_Login.do"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -3633241457409239264L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Map<String, String> errors = new HashMap<String, String>();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username == null || username.equals("")) {
			errors.put("username", "请输入用户名");
		}
		
		if (password == null || password.equals("")) {
			errors.put("password", "请输入密码");
		}
		
		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/admin/Login.jsp").forward(request, response);
			return;
		}
		
		LoginService loginSvc = LoginService.getLoginSvc();
		
		Admin admin;
		
		try {
			admin = loginSvc.getAdmin(username,password);
		} catch (LoginException e) {
			errors.put("GLOBAL", "登录失败：" + e.getMessage());
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/admin/Login.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("adminUser", admin);
		
		String requestURI = (String) session.getAttribute("login.next");
		if (requestURI == null) {
			requestURI = "/";
		}
		request.getRequestDispatcher(requestURI).forward(request, response);
		
	}
	
}
