package com.infybuzz.cloud;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



//Response Entity is the reprsenation of http response.It has headers, body content and status code.Response entity is a class whenever you want to sent the respone with custom headers,body contents and status code response entity is best

@RestController
@RequestMapping("book")
public class BookController {
	
	@GetMapping("hello")
	public String hello() {
		return "Hello World";
	}
	

	@GetMapping("helloResponseEntity")
	public ResponseEntity<String> hello1() {
		String msg= "Hello World";//body conent
		HttpHeaders headers = new HttpHeaders();
		headers.add("Desc", "Online book application");//headers
		return new ResponseEntity<String>(msg, headers,HttpStatus.OK);
	}
	
	
	
	@Autowired
	BookService bookService;    
	@GetMapping("/bookbyid/{bookid}")
	public ResponseEntity<Book> getById(@PathVariable int bookid) {
		Book book = bookService.getById(bookid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Desc", "Geeting one Book By Id");
		//instead of creating new response entity object am using static meyhod
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(book);
		 
		
//While having response entity as an return type u can return the response 
//entity as an object or call the static methods of the reponse entity.When ur
//returning as an object there are various constructor with the help of which 
//u can pass status code alone or pass status n headers or status headers n body
		
	}
	
	@GetMapping("/bookbycategory/{category}")
	public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String category) {
		List<Book> bookList =bookService.getBooksByCategory(category);
		return ResponseEntity.ok(bookList);
	}
	
	@GetMapping("/bookbyauthor")
	public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam("author") String author) {
		List<Book> book = bookService.getBooksByAuthor(author);//body
		HttpHeaders headers = new HttpHeaders();//headers
		headers.add("Desc", "Geeting one Book By Id");
		headers.add("Type", "Book Of Object");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(book);
	}
	
	@PostMapping("/books")
	public ResponseEntity<Void> addBook(@RequestBody Book book) {
		 bookService.addBook(book);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Adding one Book");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
		//build()->build the response entity with no body Returns:the response entity
		//if we dont have any body<Void> then  call the build method
	}
	
}
