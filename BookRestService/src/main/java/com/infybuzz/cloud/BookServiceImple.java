package com.infybuzz.cloud;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.infybuzz.cloud.Exception.BookNotFoundException;
import com.infybuzz.cloud.Exception.IdNotFoundException;



@Service
public class BookServiceImple implements BookService {

	@Override
	public Book getById(int bookid) {
		if(bookid<=0) {
			throw new RuntimeException("other type exception");
		}
		 Optional<Book> book = getBookList().stream().filter(e->e.getBookid()==bookid).findAny();
		 if(book.isPresent()) {
			 return book.get();
		 }
		 else {
			 throw new IdNotFoundException("Invalid Id : "+bookid);
		 }
	}

	@Override
	public List getBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		 List<Book> list = getBookList().stream().filter(e->e.getAuthor().equals(author)).collect(Collectors.toList());
		 if(list.isEmpty()){//means if author not found
			 throw new BookNotFoundException("Book with the Author :"+author+" not found");
		 }
		return list;
	}

	@Override
	public List getBooksByCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> list =getBookList().stream().filter(e->e.getCategory().equals(category)).sorted((e1,e2)->e1.getTitle().compareTo(e2.getTitle())).collect(Collectors.toList());
		 if(list.isEmpty()){
			 throw new BookNotFoundException("Book with the Category : "+category+" not found");
		 }
		return list;
	}
	
	private List<Book> getBookList(){
		
		return Arrays.asList(new Book("Java","Vishal L","Technology",1),
				new Book("Spring","Akash L","Technology",2),
				new Book("Microservices","Pooja L","Technology",3),
				new Book("Python","Sangeetha L","Technology",4),
				new Book("ML","Lalith R","Technology",5));
				
		
	}

	@Override
	public void addBook(Book book) {
		System.out.println(book);
		
	}

}
