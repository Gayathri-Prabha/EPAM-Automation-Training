package TestAutomation.testng;

public class Book {
	private int id;
	private String nameOfTheBook;
	private String authorOfTheBook;
	public Book(int id, String bookName, String author) {	
		this.id = id;
		this.nameOfTheBook = bookName;
		this.authorOfTheBook = author;	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameOfTheBook() {
		return nameOfTheBook;
	}
	public void setNameOfTheBook(String nameOfTheBook) {
		this.nameOfTheBook = nameOfTheBook;
	}
	public String getAuthorOfTheBook() {
		return authorOfTheBook;
	}
	public void setAuthorOfTheBook(String authorOfTheBook) {
		this.authorOfTheBook = authorOfTheBook;
	}
}
