package com.oracle.bir.service;

import com.oracle.bir.Exception.LoginException;
import com.oracle.bir.dao.AdminDAO;
import com.oracle.bir.domain.Admin;

public class LoginService {

	private static LoginService loginSvc = new LoginService();
	private AdminDAO adminDAO;
	
	public LoginService() {
		adminDAO = AdminDAO.getAdminDAO();
	}

	public static LoginService getLoginSvc() {
		return loginSvc;
	}

	public Admin getAdmin(String username, String password) throws LoginException {
		return adminDAO.getAdmin(username, password);
	}

}
