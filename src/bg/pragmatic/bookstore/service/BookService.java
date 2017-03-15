package bg.pragmatic.bookstore.service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.List;

import bg.pragmatic.bookstore.file.FileService;
import bg.pragmatic.bookstore.model.Book;

public class BookService {
     
	private Scanner console = new Scanner(System.in);
	private List<Book> books = new ArrayList<>();
	//tova mislya, che e dobre za masiv, koito da sudurja vsichki knigi
	
	public void addBook() {
		Book book = new Book();
		book.setId();
		//a tova shte e za dobavyane na knigite metoda
		//kato otdolo shte sloja title,author i taka natatuk
		// tuk ima dosta za dobavyane, no shte go karam po red kato vzema neshata ot Book
	}
		
	}
	 

