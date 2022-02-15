package TestAutomation.testng;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class TestLibrary {
	Library lib;
	Admin adm;
	@BeforeMethod
	public void initializeLibrary()
	{
		lib = new Library();
		lib.setCatalouge(new Catalogue());
		lib.setAdmin(new Admin(lib));
		System.out.println("Initializing Library");
		lib.getCatalouge().addBook(new Book(1, "King Lear", "William Shakespeare"));
		lib.getCatalouge().addBook(new Book(2, "Mahashweta", "Sudha Murty"));
		lib.getCatalouge().addBook(new Book(3, "Two Lives", "Vikram Seth"));
	}
	@BeforeMethod
	public void initializeMembers() {
		System.out.println("Initializing Members");
		lib.addNewMember(new Members(1, "Diva", "Prasad", "Hyderabad", 52, "Active"));
		lib.addNewMember(new Members(2, "Anu", "Radha", "Bangalore", 47, "Active"));
		lib.addNewMember(new Members(3, "Gayathri", "Prabha", "Chennai", 21, "Active"));
	}
	@Test
	public void testAddNewMember()
	{
		int initialSize = lib.getMembers().size();
		lib.addNewMember(new Members(4, "Sai", "Prabhath", "Coimbatore", 20, "Active"));
		assertEquals(lib.getMembers().size(), initialSize + 1);
	}
	@Test(dataProvider = "csvdataprovider1")
	public void testAddMember(int memberID, String firstName, String lastName, String city, int age, String status)
	{
		int initialSize = lib.getMembers().size();
		lib.addNewMember(new Members(memberID, firstName, lastName, city, age, status));
		assertEquals(lib.getMembers().size(), initialSize + 1);
	}
	@DataProvider(name = "csvdataprovider1")
	private Iterator<Object[]> csvReader2() throws Exception
	{
		List<Object[]> data = new ArrayList();
		CSVReader reader = new CSVReader(new FileReader("src/main/resources/Member.csv"));
	    String line[];
	    while ((line = reader.readNext()) != null) {
	    	Object[] member = new Object[6];
	        member[0] = Integer.parseInt(line[0]);
	        member[1] = line[1];
	        member[2] = line[2];
	        member[3] = line[3];
	        member[4] = Integer.parseInt(line[4]);
	        member[5]=line[5];
	        data.add(member);      
	    }
	    reader.close();
	    return data.iterator();   
	}
	@Test
	public void testIssueBook() {
		int initialsize=0;
		int modifiedsize=0;
		for(Iterator iterator=lib.members.iterator();iterator.hasNext();) {
			Members members=(Members)iterator.next();
			if(members.getMemberID()==3) {
				initialsize=members.getMembersBookSize();
			}
		}
		lib.getAdmin().issueBookToMember(3, 3);
		for(Iterator iterator=lib.members.iterator();iterator.hasNext();) {
			Members members=(Members)iterator.next();
			if(members.getMemberID()==3) {
				modifiedsize=members.getMembersBookSize();
			}
		}
		assertEquals(modifiedsize,initialsize+1);
	}
	@Test
	public void testdeActiveUser() {
		String s = null;
		lib.getAdmin().deActivateUser(1);
		for(Iterator iterator=lib.members.iterator();iterator.hasNext();) {
			Members members=(Members)iterator.next();
			if(members.getMemberID()==1) {
				s=members.getStatus();
				break;
			}
		}
		assertEquals("Inactive",s);   
	}
	@Test
	public void testActiveUser() {
		String s = null;
		lib.getAdmin().activateUser(3);
		for(Iterator iterator=lib.members.iterator();iterator.hasNext();) {
			Members members=(Members)iterator.next();
			if(members.getMemberID()==3) {
				s=members.getStatus();
				break;
			}
		}
		assertEquals("Active",s); 
	}
}
