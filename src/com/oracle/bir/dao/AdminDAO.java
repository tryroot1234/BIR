package com.oracle.bir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oracle.bir.Exception.BookException;
import com.oracle.bir.Exception.LoginException;
import com.oracle.bir.domain.Admin;
import com.oracle.bir.util.JDBCUtil;

public class AdminDAO {

	private static AdminDAO adminDAO = new AdminDAO();
	private static final String GET_ADMIN
			= "select * from admin where username=? and password=?";
	
	private DataSource ds;
	
	public AdminDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/BookStoreDS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	public static AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public Admin getAdmin(String username, String password) throws LoginException {
		
		Admin admin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(GET_ADMIN);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if (!rs.next()) {
				throw new LoginException("用户不存在");
			}
			
			if (!rs.isLast()) {
				throw new LoginException("有重复用户");
			}
			admin = new Admin(username, password);
		} catch (SQLException e) {
			throw new LoginException(e.getMessage());
		} finally {
			JDBCUtil.release(conn, pstmt, rs);
		}
		
		return admin;
	}

}
