package com.infybuzz.cloud;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImple implements BookService {

	@Override
	public Book getById(int bookid) {
		return getBookList().stream().filter(e->e.getBookid()==bookid).findAny().get();
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return getBookList().stream().filter(e->e.getAuthor().equals(author)).collect(Collectors.toList());
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		// TODO Auto-generated method stub
		return getBookList().stream().filter(e->e.getCategory().equals(category)).collect(Collectors.toList());
	}
	

	private List<Book> getBookList(){
		
		return Arrays.asList(new Book("Java","VishalL","Technology",1),
				new Book("Spring","AkashL","Technology",2),
				new Book("Microservices","PoojaL","Technology",3),
				new Book("Python","SangeethaL","Technology",4),
				new Book("ML","LalithR","Technology",5));
				
		
	}

}
