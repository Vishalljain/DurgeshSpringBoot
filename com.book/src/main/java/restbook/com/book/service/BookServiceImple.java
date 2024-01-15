package restbook.com.book.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import restbook.com.book.entity.Book;

@Service
public class BookServiceImple implements BookService {

	@Override
	public Book getById(int bookid) {
		return getBookList().stream().filter(e->e.getBookid()==bookid).findAny().orElse(new Book());
	}

	@Override
	public List getBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return getBookList().stream().filter(e->e.getAuthor().equals(author)).collect(Collectors.toList());
	}

	@Override
	public List getBooksByCategory(String category) {
		// TODO Auto-generated method stub
		return getBookList().stream().filter(e->e.getCategory().equals(category)).sorted((e1,e2)->e1.getTitle().compareTo(e2.getTitle())).collect(Collectors.toList());
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
