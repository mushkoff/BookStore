package bg.pragmatic.bookstore.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import bg.pragmatic.bookstore.service.BookService;

public class Menu {
	private int choice;
	private boolean logOutflagAdmin = true;
	private boolean logOutflagSeller = true;
	private boolean incorrectPasswordFlag = true;
	private Scanner console = new Scanner(System.in);
	private BookService service = new BookService();

	public void start() {
		while (incorrectPasswordFlag) {
			// using flag incorrectPasswordFlag so the program will not shut
			// down
			// if we put wrong password
			// the program will end when we sellect Exit button

			logOutflagAdmin = true;
			logOutflagSeller = true;
			int login = service.login();
			// login method
			switch (login) {
			case 1:

				while (logOutflagAdmin) {
					System.out.println("Login like administrator !\n");
					System.out.println("Please choose :\n 1-> Add book\n 2-> Search book by title\n"
							+ " 3-> Show all books\n 4-> Sell 3 copies of book\n 5-> Delete book\n 6-> Edit book\n 7-> Switch user \n 8-> Exit");
					try {
						choice = console.nextInt();
						// selecting menu option
						console.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Pleae enter correct data !");
						break;
					}

					System.out.println("You choose " + choice);
					switch (choice) {
					case 1:
						service.addBook();
						break;
					case 2:
						System.out.println("Please enter title:");
						String bookTitleSearch = console.nextLine();
						service.searchByTitle(bookTitleSearch);

						break;
					case 3:
						service.showAllBooks();
						break;
					case 4:
						System.out.println("Please enter title:");
						String bookTitleSell = console.nextLine();
						service.sellTripleCountOfBook(bookTitleSell);

						break;
					case 5:
						System.out.println("Please enter title:");
						String bookTitleDelete = console.nextLine();
						service.deleteBook(bookTitleDelete);
						break;
					case 6:
						System.out.println("Please enter title:");
						String bookTitleEdit = console.nextLine();
						service.editBook(bookTitleEdit);
						System.out.println("You edit book " + bookTitleEdit + "succesfull !");
						break;
					case 7:
						logOutflagAdmin = false;
						System.out.println("Bye bye admin!");
						break;
					case 8:
						incorrectPasswordFlag = false;
						logOutflagAdmin = false;
						System.out.println("Bye bye !");
						break;
					default:
						break;
					}
				}
				break;
			case 2:
				while (logOutflagSeller) {
					System.out.println("Login like seller !\n");
					System.out.println("Please choose :\n 1-> Search book by title\n"
							+ " 2-> Show all books\n 3-> Sell 3 copies of book\n 4-> Swtich user\n 5-> Exit");
					choice = console.nextInt();
					console.nextLine();
					System.out.println("You choose " + choice);
					switch (choice) {
					case 1:
						System.out.println("Please enter title:");
						String bookTitleSearch = console.nextLine();
						service.searchByTitle(bookTitleSearch);

						break;
					case 2:
						service.showAllBooks();
						break;
					case 3:
						System.out.println("Please enter title:");
						String bookTitleSell = console.nextLine();
						service.sellTripleCountOfBook(bookTitleSell);
						break;
					case 4:
						logOutflagSeller = false;
						System.out.println("Bye bye seller !");
						break;
					case 5:
						incorrectPasswordFlag = false;
						logOutflagSeller = false;
						System.out.println("Bye bye !");
						break;
					default:
						break;
					}
				}
				break;
			default:
				System.out.println("Incorrect password ! Please try again :)\n");
				break;
			}
		}
	}
}
