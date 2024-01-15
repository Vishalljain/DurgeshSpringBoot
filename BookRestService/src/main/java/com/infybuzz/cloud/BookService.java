package com.infybuzz.cloud;

import java.util.List;

import com.infybuzz.cloud.Exception.BookNotFoundException;
import com.infybuzz.cloud.Exception.IdNotFoundException;



public interface BookService {
	void addBook(Book book);
	Book getById(int bookid) throws IdNotFoundException;
	List getBooksByAuthor(String author) throws BookNotFoundException;
	List getBooksByCategory(String category) throws BookNotFoundException;

}
