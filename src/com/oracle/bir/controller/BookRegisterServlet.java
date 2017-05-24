package com.oracle.bir.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.bir.Exception.BookException;
import com.oracle.bir.domain.Book;
import com.oracle.bir.service.BookService;

@WebServlet(name="BookRegisterServlet", urlPatterns={"/admin/BookRegister.do"})
public class BookRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 8038397109825246791L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Map<String, String> errors = new HashMap<String, String>();
		
		String bidStr = request.getParameter("bid");
		String name = request.getParameter("name").trim();
//		String category = request.getParameter("category");
		String[] categorys = request.getParameterValues("category");
		String author = request.getParameter("author").trim();
		String discount = request.getParameter("discount");
		String priceStr = request.getParameter("price").trim();
		String amountStr = request.getParameter("amount").trim();
		String profile = request.getParameter("profile").trim();
		
		int bid = 0;
		try {
			bid = Integer.parseInt(bidStr);
		} catch (NumberFormatException e) {
			errors.put("bid", "id不存在");
		}
		
		double price = 0;
		try {
			price = Double.parseDouble(priceStr);
		} catch (NumberFormatException e) {
			errors.put("price", "价格必须是整数或小数");
		}
		
		int amount = 0;
		try {
			amount = Integer.parseInt(amountStr);
		} catch (NumberFormatException e) {
			errors.put("amount", "数量必须是整数");
		}
		
		if (name == null || name.equals(""))
			errors.put("name", "请填写书名");
		
		String category = "";
		if (categorys == null)
			errors.put("category", "请选择分类");
		else {
			for (String cate : categorys) {
				category += cate + ",";
			}
			category = category.substring(0, category.length()-1);
		}
		
		String category_c = null;
		/*try {
			for (int i = 0; i < category.length; i++) {
				System.out.println(category[i]);
				category_c = category_c + "," + category[i];
			}
		} catch (Exception e) {
			errors.put("category","请选择分类");
		}*/
		
		if (author == null || author.equals(""))
			errors.put("author", "请填写作者");
		
		if (discount == null || discount.equals(""))
			errors.put("discount", "请选择折扣");
		
		double discount_s = 0;
		try {
			if (discount.equals("全价")) {
				discount_s = 1;
			} else if (discount.equals("9折")) {
				discount_s = 0.9;
			} else if (discount.equals("8折")) {
				discount_s = 0.8;
			} else if (discount.equals("7折")) {
				discount_s = 0.7;
			} else if (discount.equals("6折")) {
				discount_s = 0.6;
			}
		} catch (Exception e1) {
			errors.put(discount, "请选择折扣");
		}
		
		if (priceStr == null || priceStr.equals(""))
			errors.put("price", "请填写价格");
		
		if (price < 0) {
			errors.put("price", "价格必须大于0");
		}
		
		if (amountStr == null || amountStr.equals(""))
			errors.put("amount", "请填写数量");
		
		if (amount < 0) {
			errors.put("amount", "数量必须大于0");
		}
		
		if (profile == null || profile.equals(""))
			errors.put("profile", "请填写简介");
		
		if (!errors.isEmpty()) {
			//转至当前页面，显示错误信息
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/admin/BookRegister.jsp").forward(request, response);
			return;
		}
		
		BookService bookSvc = BookService.getBookSvc();
		
		try {
			Book book = bookSvc.createBook(bid, name, category, author, discount_s, price, amount, profile);
			request.setAttribute("book", book);
		} catch (BookException e) {
			errors.put("GLOBAL", "添加失败，原因："+e.getMessage());
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/admin/BookRegister.jsp").forward(request, response);
			return;
		}
		
		//请求转发
		request.getRequestDispatcher("/admin/BookRegisterSucc.jsp").forward(request, response);
		
	}
	
}












