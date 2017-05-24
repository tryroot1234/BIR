package com.oracle.bir.domain;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 6587565651770458493L;

	private int bid;//编号
	private String name;//书名
	private String category;//类别
	private String author;//作者
	private double discount;//折扣
	private double price;//价格
	private int amount;//数量
	private String profile;//简介
	
	public Book() {
		
	}

	/**
	 * 此构造方法用于登记书籍
	 */
	public Book(String name, String category, String author,
			double discount, double price, int amount, String profile) {
		this.name = name;
		this.category = category;
		this.author = author;
		this.discount = discount;
		this.price = price;
		this.amount = amount;
		this.profile = profile;
	}

	public Book(int bid, String name, String category, String author,
			double discount, double price, int amount, String profile) {
		super();
		this.bid = bid;
		this.name = name;
		this.category = category;
		this.author = author;
		this.discount = discount;
		this.price = price;
		this.amount = amount;
		this.profile = profile;
	}

	public Book(int bid, String name, String author, double price, int amount) {
		this.bid = bid;
		this.name = name;
		this.author = author;
		this.price = price;
		this.amount = amount;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", name=" + name + ", category=" + category
				+ ", author=" + author + ", discount=" + discount
				+ ", price=" + price + ", amount=" + amount + ", profile="
				+ profile + "]";
	}
	
}
