package com.infybuzz.cloud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("book")
public class BookController {
	
	@GetMapping("hello")
	public String hello() {
		return "Hello World";
	}
	
	@Autowired
	BookService bookService;    
	//http://localhost:8080/book/bookbyid/2
	@GetMapping("/bookbyid/{bookid}")
	public Book getById(@PathVariable int bookid) {
		return bookService.getById(bookid);
		
	}
	
	@GetMapping("/bookbycategory/{category}")
	public List<Book> getBooksByCategory(@PathVariable String category) {
		return bookService.getBooksByCategory(category);
	}
	
	@GetMapping("/bookbyauthor")
	public List<Book> getBooksByAuthor(@RequestParam("author") String author) {
		return bookService.getBooksByAuthor(author);
	}
}
