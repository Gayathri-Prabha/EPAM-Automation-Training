package TestAutomation.testng;

import java.util.ArrayList;
import java.util.Iterator;

public class Admin {
	public Members members;
	public Library lib;
	public Catalogue c;
	public Admin(Library lib) {
		this.lib=lib;
	}
	public void deActivateUser(int memberID) {
		for (Iterator iterator = lib.members.iterator(); iterator.hasNext();) {
			Members members = (Members) iterator.next();
			if(members.getMemberID()==memberID) {
				members.deActivateUser();
			}
		}
	}
	public void activateUser(int memberID) {
		for (Iterator iterator = lib.members.iterator(); iterator.hasNext();) {
			Members members = (Members) iterator.next();
			if(members.getMemberID()==memberID) {
				members.activateUser();
			}
		}
	}
	void issueBookToMember(int memberID, int bookID) {
		for(Iterator iterator=lib.members.iterator(); iterator.hasNext();) {
			Members members = (Members) iterator.next();
			if (members.getMemberID() == memberID) {
				for (Iterator iterator1 = lib.getCatalouge().books.iterator(); iterator1.hasNext();) {
					Book book = (Book) iterator1.next();
					if (book.getId() == bookID) {
						members.issuedBooks.add(book);
						System.out.println("Book Issued");
						break;
					}else {
						System.out.println("Inactive User");
					}
				}
			}
		}
	}
}
