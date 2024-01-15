package restbook.com.book.service;

import java.util.List;

import restbook.com.book.entity.Book;

public interface BookService {
	void addBook(Book book);
	Book getById(int bookid);
	List getBooksByAuthor(String author);
	List getBooksByCategory(String category);

}
