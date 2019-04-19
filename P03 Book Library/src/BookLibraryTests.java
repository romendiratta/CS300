//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Book Class
// Files:           Subscriber.java, Librarian.Java, Book.java, Library.java
// Course:          CS300 Spring 2019
//
// Author:          Rohan Mendiratta
// Email:           rmendiratta@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Paul Bartlett
// Partner Email:   psbartlett@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   x Write-up states that pair programming is allowed for this assignment.
//   x We have both read and understand the course Pair Programming Policy.
//   x We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;

/**
 * @author Rohan
 * @author Paul
 * @version 1.0
 */
public class BookLibraryTests {

  /**
   * checks whether the constructor of your Book class initializes correctly the new Book
   * instance fields: title, author, borrowerCardBarCode, ID, and increments nextID static field.
   * @return true if tests pass, false otherwise.
   */
  public static boolean testBookConstructorGetters(){
    boolean res = true; // test boolean
    Book testBook1 = new Book("Test Title", "Test Author"); // test book 1
    Book testBook2 = new Book("Test Title 2", "Test Author 2"); // test book 2
    testBook2.borrowBook(100); // borrows the second test book with bar code 100
	// Checks that the authors are set correctly
    if (!testBook1.getAuthor().equals("Test Author") ||
		!testBook2.getAuthor().equals("Test Author 2")) {
      res = false;
	}
	// Checks that the titles are set correctly
	if(!testBook1.getTitle().equals("Test Title") ||
		!testBook2.getTitle().equals("Test Title 2")){
	  res = false;
	}
	// checks that the book has been set to borrowed
	if (testBook1.getBorrowerCardBarCode() != null) {
	  res = false;
	}
	// Checks that the book_id has been set correctly
	if (testBook1.getID() !=1 || testBook2.getID() != 2) {
	  res = false;
	}
	// Checks that the borrower code is set correctly
	if (testBook2.getBorrowerCardBarCode() != 100) {
	  res = false;
	}
	return res;
  }

  /**
   *  checks whether returnBook() method defined within your Book class sets correctly the
   *  instance field borrowerCardBarCode. A Book must be available after this instance method
   *  is called.
   * @return true if tests pass, false otherwise.
   */
  public static boolean testBookReturnBook() {
	boolean res = true; // test boolean
	Book testBook1 = new Book("Test Title", "Test Author"); // creates a new book
	testBook1.borrowBook(100); // borrows the book with code 100
	if (testBook1.getBorrowerCardBarCode() != 100) { // checks that the bar code is set 100
	  res = false;
	}
	testBook1.returnBook(); // Returns the books
	if (testBook1.getBorrowerCardBarCode() != null) { // Checks that it has been set back to null
	  res = false;
	}
	return res;
  }

  /**
   *This unit test method checks whether the checkoutBook() method defined within the
   * Subscriber class works correctly.
   * @return true if tests pass, false otherwise.
   */
  public static void testSubscriberCheckoutBook() {
    // creates 2 new subscribers
    Subscriber subscriber = new Subscriber(
    	"Test Name", 1234, "1234 Main St.","123-456-7890" );
	Subscriber subscriber2 = new Subscriber(
		"Test Name2", 1234, "1234 Main St.","123-456-7890" );
	// creates 10 new books
	Book book1 = new Book("Title1", "Author1");
	Book book2 = new Book("Title2", "Author2");
	Book book3 = new Book("Title3", "Author3");
	Book book4 = new Book("Title4", "Author4");
	Book book5 = new Book("Title5", "Author5");
	Book book6 = new Book("Title6", "Author6");
	Book book7 = new Book("Title7", "Author7");
	Book book8 = new Book("Title8", "Author8");
	Book book9 = new Book("Title9", "Author9");
	Book book10 = new Book("Title10", "Author10");
	// Checks that the correct messages come up when too many books are checked out
    subscriber.checkoutBook(book1);
    subscriber2.checkoutBook(book1);
    subscriber.checkoutBook(book1);
	subscriber.checkoutBook(book2);
	subscriber.checkoutBook(book3);
	subscriber.checkoutBook(book4);
	subscriber.checkoutBook(book5);
	subscriber.checkoutBook(book6);
	subscriber.checkoutBook(book7);
	subscriber.checkoutBook(book8);
	subscriber.checkoutBook(book9);
	subscriber.checkoutBook(book10);
	subscriber.checkoutBook(book1);
  }

  /**
   * This unit test method checks to see if the Librarian class works correctly.
   * @return true if tests pass, false otherwise.
   */
  public static boolean testLibrarian() {
    boolean res = true; // test boolean
	// creates a new librarian
    Librarian librarian = new Librarian("username", "password");

    if (!librarian.getUsername().equals("username")) { // checks that ther username is set correctly
      res = false;
	}
	// checks that false is returned when the wrong password is used
	if(librarian.checkPassword("falsepassword")) {
	  res = false;
	}
	// checks that true is returned when the correct password is used
	if(!librarian.checkPassword("password")) {
	  res = false;
	}

    return res;
  }

  /**
   * This unit test method checks whether the FindByAuthor() method defined within the
   * Library class works correctly.
   * @return true if tests pass, false otherwise.
   */
  public static boolean testLibraryFindBookByAuthor() {
    boolean res = true; // test boolean
	ArrayList<Book> correctArray = new ArrayList<>(); // arraylist of the correct books
	ArrayList<Book> resArray; // arraylist of the resulting array
	correctArray.add(new Book("Test Book 1", "Test Author 1")); // test book 1
	correctArray.add(new Book("Test Book 1", "Test Book 2")); // test book 2
    Library test = new Library( // creates a new library
    	"1234 Main St.", "username", "password");
    test.addBook("Test Book 1", "Test Author 1"); // adds a book to the test library
    test.addBook("Test Book 2", "Test Author 2");
    resArray = test.findBookByAuthor("Author"); // calls the findBookByAuthor method
	// Checks that the resulting array is correct.
    if (!resArray.get(0).getAuthor().equals(correctArray.get(0).getAuthor()) ||
		!resArray.get(1).getAuthor().equals(correctArray.get(1).getAuthor())) {
      res = false;
	}
    return res;
  }

  /**
   * This method is the driver of all of the unit tests.
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testBookConstructorGetters());
	System.out.println(testBookReturnBook());
	testSubscriberCheckoutBook();
	System.out.println(testLibrarian());
	System.out.println(testLibraryFindBookByAuthor());
  }
}
