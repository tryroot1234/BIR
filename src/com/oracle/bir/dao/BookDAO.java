package com.oracle.bir.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oracle.bir.Exception.BookException;
import com.oracle.bir.domain.Book;
import com.oracle.bir.service.BookService;
import com.oracle.bir.util.JDBCUtil;

public class BookDAO {

	private static BookService bookSvc = BookService.getBookSvc();
	private static BookDAO bookDAO = new BookDAO();
	private static final String INSERT_NEW_BOOK 
			= "insert into book(name, category, author, discount, price, amount, profile) values (?,?,?,?,?,?,?)";
	private static final String SELECT_ALL
			= "select * from book";
	private static final String SELECT_BY_ID
			= "select * from book where bid=?";
	
	private DataSource ds;
	
	/**
	 * 此构造方法用来加载 DataSource 驱动
	 */
	private BookDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/BookStoreDS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回 BookDAO 的实例对象
	 * @return bookDAO
	 */
	public static BookDAO getBookDAO() {
		return bookDAO;
	}

	/**
	 * 查询所有书籍信息
	 * @return books
	 * @throws BookException 
	 */
	public List<Book> getBooks() throws BookException {
		List<Book> books = new ArrayList<Book>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String name = rs.getString("name");
				String category = rs.getString("category");
				String author = rs.getString("author");
				double discount = rs.getDouble("discount");
				double price = rs.getDouble("price");
				int amount = rs.getInt("amount");
				String profile = rs.getString("profile");
				
				Book book = new Book(bid, name, category, author, discount, price, amount, profile);
				books.add(book);
			}
		} catch (SQLException e) {
			throw new BookException("数据库错误" + e.getMessage());
		} finally {
			JDBCUtil.release(conn, pstmt, rs);
		}
		
		return books;
	}
	

	/**
	 * 此方法用于向数据库中添加书籍信息
	 * @param book
	 * @throws BookException
	 */
	public void insertBook(Book book) throws BookException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(INSERT_NEW_BOOK);
			
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getCategory());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDouble(4, book.getDiscount());
			pstmt.setDouble(5, book.getPrice());
			pstmt.setInt(6, book.getAmount());
			pstmt.setString(7, book.getProfile());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new BookException("数据库错误，无法添加"+e.getMessage());
		} finally {
			JDBCUtil.release(conn, pstmt, null);
		}
		
		
	}

	public Book findBookById(int bid) throws BookException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String name = rs.getString("name");
				String category = rs.getString("category");
				String author = rs.getString("author");
				double discount = rs.getDouble("discount");
				double price = rs.getDouble("price");
				int amount = rs.getInt("amount");
				String profile = rs.getString("profile");
				
				book = new Book(bid, name, category, author, discount, price, amount, profile);
			}
		} catch (SQLException e) {
			throw new BookException("数据库错误" + e.getMessage());
		} finally {
			JDBCUtil.release(conn, pstmt, rs);
		}
		return book;
	}

}
