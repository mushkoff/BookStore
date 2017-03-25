package bg.pragmatic.bookstore.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import bg.pragmatic.bookstore.file.FileService;
import bg.pragmatic.bookstore.model.Book;

public class BookService {
	private Scanner console = new Scanner(System.in);
	private List<Book> books = new ArrayList<>();

	// Array list which contains all the books
	public void addBook() {
		// method, which adds books in main list

		Book book = new Book();
		book.setId(UUID.randomUUID());
		try {
			console.nextLine();
			System.out.println("Enter book title :");
			book.setTitle(console.nextLine());
			System.out.println("Enter book author :");
			book.setAuthor(console.nextLine());
			System.out.println("Enter book price :");
			book.setPrice(console.nextDouble());
			console.nextLine();
			System.out.println("Enter book publisher :");
			book.setPublisher(console.nextLine());
			System.out.println("Is book foreigh ? :");
			book.setForeign(console.nextBoolean());
			System.out.println("Enter book count :");
			book.setCount(console.nextInt());
			console.nextLine();
		} catch (InputMismatchException e) {
			// catches InputMismatchException when you put incorect data
			System.out.println("Please enter correct data !");
			return;
		}
		books.add(book);
		// add new book in main list
		FileService.writeInFile(books);
		System.out.println("Book was added succesfull !");
	}

	public List<Book> searchByTitle(String title) {

		List<Book> books = new ArrayList<>();
		for (Book book : this.books) {
			if (book.getTitle().contains(title))
				books.add(book);
		}
		System.out.println("List of books wtih " + title + " :");
		for (Book book : books) {
			// crawls new list with books and put
			// info in console for each one
			System.out.println(book.toString());
		}
		return books;
	}

	public void showAllBooks() {
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

	public void sellTripleCountOfBook(String title) {

		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				book.setCount((book.getCount() - 3));
				System.out.println("3 copies of " + title + " was sold !");
			}
		}
	}

	public void deleteBook(String title) {
		Book tempBook = new Book();
		// create a book which will take value of the book which we`ve given
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				tempBook = book;
			}
		}
		books.remove(tempBook);
		System.out.println("Book " + title + " was removed from list !");

	}

	public void editBook(String title) {
		Book editedBook = new Book();
		List<Book> temporaryBookList = new ArrayList<>();
		temporaryBookList.addAll(books);
		for (Book book : temporaryBookList) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				editedBook = book;
				try {
					System.out.println("Current book : \n" + editedBook.toString());
					System.out.println("Enter new title of book: ");
					editedBook.setTitle(console.nextLine());
					System.out.println("Enter new book author :");
					editedBook.setAuthor(console.nextLine());
					System.out.println("Enter new book price :");
					editedBook.setPrice(console.nextDouble());
					console.nextLine();
					System.out.println("Enter new book publisher :");
					editedBook.setPublisher(console.nextLine());
					System.out.println("Is new book foreigh ? :");
					editedBook.setForeign(console.nextBoolean());
					System.out.println("Enter new book count :");
					editedBook.setCount(console.nextInt());
					console.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("Please enter correct data !");
					return;
				}

				books.remove(book);
			}
			books.add(editedBook);
		}

	}

	public int login() {
		// login method
		String adminPassword = "admin";
		// this is the password for user - admin
		String sellerPassowrd = "seller";
		// password for user - seller
		System.out.println("Password : ");
		String enteredPassword = console.nextLine();
		if (enteredPassword.equals(adminPassword))
			// this equals is for correct password (return 1)
			return 1;
		else if (enteredPassword.equals(sellerPassowrd))
			// for correct seller password - returns 2
			return 2;
		else
			return 0;
		// if the passwords are incorect returns - 0
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
