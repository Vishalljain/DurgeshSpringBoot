package com.infybuzz.cloud;




public class Book {

	private String title;
	private String author;
	private String category;
	private int bookid;
	public Book(String title, String author, String category, int bookid) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.bookid = bookid;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", bookid=" + bookid + "]";
	}
	
	
	
	

}
