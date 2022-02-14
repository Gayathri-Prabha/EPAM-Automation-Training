package TestAutomation.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCatalogue {
	Library lib;
	@BeforeGroups(groups = {"basicOperation","Alltests"})
	public void initializeLibrary()
	{
		lib = new Library();
		lib.setCatalouge(new Catalogue());	
		System.out.println("Initializing Library");	
		lib.getCatalouge().addBook(new Book(1, "Angels & Demons", "Dan Brown"));
		lib.getCatalouge().addBook(new Book(2, "Lost Symbol", "Dan Brown"));
		lib.getCatalouge().addBook(new Book(3, "Ramayana", "Valmiki"));
	}
	@Test(groups = {"basicOperation","Alltests"})
	public void testCatalogueAddBook()
	{
		int initialSize = lib.getCatalouge().getCatalogueSize();
		lib.getCatalouge().addBook(new Book(4, "Mahabhartha", "VedVyas"));
		assertEquals(lib.getCatalouge().getCatalogueSize(), initialSize + 1);
	}
	@Test(groups = {"basicOperation","Alltests"})
	public void testCatalogueRemoveBook()
	{
		int initialSize = lib.getCatalouge().getCatalogueSize();
		int idToRemove = lib.getCatalouge().getBooks().get(0).getId();	
		lib.getCatalouge().removeBook(idToRemove);
		assertEquals(lib.getCatalouge().getCatalogueSize(), initialSize - 1);	
	}
	@Test(groups = {"basicOperation","Alltests"})
	public void testCatalogueRemoveNonExistingBook()
	{
		int initialSize = lib.getCatalouge().getCatalogueSize();
		lib.getCatalouge().removeBook(102);
		assertEquals(lib.getCatalouge().getCatalogueSize(), initialSize);	
	}
	@Test(groups = {"Alltests"})
	public void testCatalogueSearchByBookName()
	{
		Book book = lib.getCatalouge().searchBook("Symbol");
		assertNotNull(book);
	}
	@Test(groups = {"Alltests"})
	public void testCatalogueSearchByBookNamewhichDoesNotExist()
	{
		Book book = lib.getCatalouge().searchBook("Geeta");
		assertNull(book);
	}
	@Test(groups = {"Alltests"})
	public void testCatalogueSearchByAuthorname()
	{
		Book book = lib.getCatalouge().searchBook("Brown");
		assertNotNull(book);
	}
	@Test(groups = {"Alltests"})
	public void testCatalogueSearchByAuthornameWhichDoesNotExist()
	{
		Book book = lib.getCatalouge().searchBook("Chetan");	
		assertNull(book);
	}
	@Test(groups = {"Alltests","basicOperation"})
	public void testAddToLibraryWithSupportedObject()
	{
		int initialSize = lib.getCatalouge().getCatalogueSize();
		try
		{
			lib.getCatalouge().addToLibrary(new Book(5, "Mahabhartha", "VedVyas"));
		}catch(Exception e)
		{
			// not expecting any exception
		}	
		assertEquals(lib.getCatalouge().getCatalogueSize(), initialSize + 1);	
	}
	@Test(groups = {"Alltests"}, expectedExceptions = LibraryObjectNotSupported.class)
	public void testAddToLibraryWithUnsupportedObject() throws Exception
	{
		lib.getCatalouge().addToLibrary("New Video");	
	}
	/**
	 * test is dependent on testCatalogueAddBook method.
	 * if dependency is not added testcase will fail.
	 */
	@Test(groups = {"Alltests"}, dependsOnMethods = {"testCatalogueAddBook"})
	public void testARemoveNewlyAddedBook()
	{
		int initialSize = lib.getCatalouge().getCatalogueSize();			
		lib.getCatalouge().removeBook(4);
		assertEquals(lib.getCatalouge().getCatalogueSize(), initialSize - 1);		
	}
	/**
	 * test is dependent on basic Operation group.
	 * if dependency is not added testcase will fail.
	 */
	@Test(groups = {"Alltests"}, dependsOnGroups = {"basicOperation"})
	public void testARemoveNewlyAddedBook2()
	{
		int initialSize = lib.getCatalouge().getCatalogueSize();			
		lib.getCatalouge().removeBook(5);
		assertEquals(lib.getCatalouge().getCatalogueSize(), initialSize - 1);	
	}	
	@Test(groups = {"basicOperation","Alltests"}, dataProvider = "BookNames")
	public void testCatalogueAddBooks(int bookID,String bookName, String authorName)
	{
		System.out.println("Calling test add Books for : " + bookName);
		int initialSize = lib.getCatalouge().getCatalogueSize();
		lib.getCatalouge().addBook(new Book(bookID, bookName, authorName));		
		assertEquals(lib.getCatalouge().getCatalogueSize(), initialSize + 1);		
	}
	@Test(groups = {"basicOperation","Alltests"}, dataProvider = "BookNamesV2")
	public void testCatalogueAddBooks(Book book)
	{
		int initialSize = lib.getCatalouge().getCatalogueSize();
		lib.getCatalouge().addBook(book);	
		assertEquals(lib.getCatalouge().getCatalogueSize(), initialSize + 1);	
	}	
	@Test(groups = {"Alltests"})
	@Parameters("searchStr")
	public void testCatalogueSearchByBookNamePara(String searchStr)
	{
		Book book = lib.getCatalouge().searchBook(searchStr);
		assertNotNull(book);
	}
	@DataProvider(name = "BookNames")
	public static Object[][] bookNames()
	{
		return new Object[][] {
			{6,"Harry Potter","J K Rowling"},
			{7,"wings of Fire","APJ Kalam"},
			{8,"Believe","Suresh Raina"},
			{9,"Psycology of Money","Morgan"},
			{10,"Rich Dad Poor Dad","Robert"},
			{11,"Zero to One","Peter"},
			{12,"Arthshashtra","Kautilaya"},
			{13,"כנפי אש","קאוטיליה"},
			{14,"カウティラヤ","カウティラヤ"},
			{15,"考提拉亞","考提拉亞"}
			
		};
	}
	@DataProvider(name = "BookNamesV2")
	public static Object[][] bookNamesVer2()
	{
		return new Object[][] {{
			new Book(7,"wings of Fire","APJ Kalam")
		}
		};
	}
}
