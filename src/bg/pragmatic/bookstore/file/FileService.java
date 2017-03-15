package bg.pragmatic.bookstore.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import bg.pragmatic.bookstore.model.Book;

public class FileService {

	private static File file = new File("./resources/bookstore.txt");

	public static void writeInFile(List<Book> books) {
		//obhojda lista books i zapisva vsyaka kniga vuv faila posledvan ot nov red 
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			for (Book book : books) {
				bw.write(book.toString());
				bw.newLine();
			}
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
