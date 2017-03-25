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
<<<<<<< HEAD
=======
		
		//testing push
		///obhojda lista books i zapisva vsyaka kniga vuv faila posledvan ot nov red 
>>>>>>> fe04dd0b41fe9621bcedfdf0f55bea43eaec8272
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
			for (Book book : books) {
				//crawls book list and save every book in the file, then new row
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
