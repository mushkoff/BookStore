package bg.pragmatic.bookstore.model;

import java.util.UUID;

public class Book {
	
	private UUID id;
	private String title;
	private String author;
	private double price;
	private String publisher;
	private boolean isForeign;
	private int count;
	

	public Book(String title, String author, double price, String publisher, boolean isForeign, int count) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.isForeign = isForeign;
		this.count = count;
	}

	public Book() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean isForeign() {
		return isForeign;
	}

	public void setForeign(boolean isForeign) {
		this.isForeign = isForeign;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ID: "+id+"\nTitle: " + title + "\nAuthor: " + author + "\nPrice: " + price + "\nPublisher: " + publisher
				+ "\nForeign?: " + isForeign + "\nCount: " + count+"\n\n";
	}
}
