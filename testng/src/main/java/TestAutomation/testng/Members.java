package TestAutomation.testng;

import java.util.ArrayList;

public class Members {
	private int memberID;
	private String firstName;
	private String lastName;
	private String city;
	private int age;
	public String status;
	public ArrayList<Book> issuedBooks;
	public Members() {
		this.issuedBooks = new ArrayList<Book>();
	}
	public Members(int id, String Fname, String Lname, String city, int age, String status) {
		this.memberID = id;
		this.firstName = Fname;
		this.lastName = Lname;
		this.city = city;
		this.age = age;
		this.status = status;
		this.issuedBooks = new ArrayList<Book>();
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<Book> getIssuedBooks() {
		return issuedBooks;
	}

	public void setIssuedBooks(ArrayList<Book> issuedBooks) {
		this.issuedBooks = issuedBooks;
	}
	public int getMembersBookSize() {
		return this.issuedBooks.size();
	}
	public void activateUser()
	{
		this.status = "Active";
	}
	public void deActivateUser()
	{
		this.status = "Inactive";
	}
}
