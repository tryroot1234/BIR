package com.oracle.bir.service;

import java.util.List;

import com.oracle.bir.Exception.BookException;
import com.oracle.bir.dao.BookDAO;
import com.oracle.bir.domain.Book;

public class BookService {

	private static BookService bookSvc = new BookService();
	//创建DAO对象和Book服务对象, 目的是调用bookDAO里面的方法
	private BookDAO bookDAO;
	private static final String[] CATEGORY_SHOW = {"科学", "教育", "文学", "生活", "其他"};
	private static final String[] CATEGORY_SQL = {"S", "E", "W", "L", "O"};
	private static final String[] DISCOUNT_SHOW = {"全价", "9折", "8折", "7折", "6折"};
	private static final double[] DISCOUNT_SQL = {1.0, 0.9, 0.8, 0.7, 0.6};
	
	/**
	 * 得到 BookDAO 的实例对象
	 */
	private BookService(){
		bookDAO = BookDAO.getBookDAO();
	}
	
	/**
	 * 得到 BookService 服务对象
	 * @return bookSvc
	 */
	public static BookService getBookSvc() {
		return bookSvc;
	}

	/**
	 * 此方法用于从 BookDAO 中得到 Book 集合
	 * @return bookDAO.getBooks()
	 * @throws BookException
	 */
	public List<Book> getBooks() throws BookException {
		return bookDAO.getBooks();
	}
	
	/**
	 * 此方法用于登记新书籍
	 * @return book
	 * @throws BookException
	 */
	public Book createBook(int bid, String name, String category_c,
			String author, double discount, double price, int amount,
			String profile) throws BookException {
		
		Book book = new Book(name, category_c, author, discount, price, amount, profile);
		bookDAO.insertBook(book);
		return book;
	}
	
	/**
	 * 此方法用于返回分类数组
	 * @return CATEGORY
	 */
	public String[] getCategorys(){
		return CATEGORY_SHOW;
	}
	
	public String[] getCategory(){
		return CATEGORY_SQL;
	}

	/**
	 * 此方法用于返回折扣数组
	 * @return DISCOUNT
	 */
	public String[] getDiscounts(){
		return DISCOUNT_SHOW;
	}
	
	public double[] getDiscount(){
		return DISCOUNT_SQL;
	}
	
	public Book getDetails(int bid) throws BookException{
		Book book = bookDAO.findBookById(bid);
		return book;
	}
	
}
