//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Book Class
// Files:           Book.java, Librarian.Java, Library.java
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
public class Subscriber {
  // static fields
  private final static int MAX_BOOKS_CHECKED_OUT = 10; // maximum number of books to be checked out
  // one subscriber
  private static int nextCardBarCode = 2019000001; // class variable that represents the card bar
  // code of the next subscriber to be created
// Instance fields
  private int pin; // 4-digits Personal Identification Number to verify the identity of this
  // subscriber
  private final Integer CARD_BAR_CODE; // card bar code of this subscriber

  private String name; // name of this subscriber
  private String address; // address of this subscriber
  private String phoneNumber; // phone number of this subscriber

  private ArrayList<Book> booksCheckedOut; // list of books checked out by this subscriber and not
  // yet returned. A subscriber can have at most 10 checked out books
  private ArrayList<Book> booksReturned; // list of the books returned by this subscriber

  /**
   * Creates a new subscriber with given name, address, and phone number,
   * and initializes its other instance fields.
   * @param name name of this subscriber
   * @param pin 4-digits personal information number of this subscriber
   * @param address address of this subscriber
   * @param phoneNumber phone number of this subscriber
   */
  public Subscriber(String name, int pin, String address, String phoneNumber) {
    this.name = name;
    this.pin = pin;
    this.address = address;
    this.phoneNumber = phoneNumber;
    CARD_BAR_CODE = nextCardBarCode;
    nextCardBarCode++;
    booksCheckedOut = new ArrayList<>();
    booksReturned = new ArrayList<>();
  }

  /**
   * Returns this subscriber's address
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * Updates this subscriber's address
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Returns this subscriber's phone number
   * @return the phoneNumber
   */
  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  /**
   * Updates this subscriber's phone number
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Returns this subscriber PIN (4-digits Personal Identification Number)
   * @return the pin
   */
  public int getPin() {
    return this.pin;
  }

  /**
   * Returns this subscriber's card bar code
   * @return the CARD_BAR_CODE
   */
  public Integer getCARD_BAR_CODE() {
    return this.CARD_BAR_CODE;
  }

  /**
   * Returns this subscriber's name
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Checks out an available book. The checkout operation fails if the maximum number of checked
   * out books by this subscriber is already reached.
   * @param book reference to the book to be checked out by this subscriber
   */
  public void checkoutBook(Book book) {
    // Checks the size against the max amount of books that can be checked out.
    if (booksCheckedOut.size() >= MAX_BOOKS_CHECKED_OUT) {
	  System.out.println("Checkout Failed: You cannot check out more than " +
		  MAX_BOOKS_CHECKED_OUT + " books.");
	}
	// Checks that the subscriber has not already checked out the book
	else if(booksCheckedOut.contains(book)){
	  System.out.println("You have already checked out " + book.getTitle() + " book.");
	}
	else if(!book.isAvailable()) { // Checks if the book is avaible
		System.out.println("Sorry, " + book.getTitle() + " is not available.");
	}
	else {
	  book.borrowBook(CARD_BAR_CODE); // Borrows the book
	  booksCheckedOut.add(book); // Adds the book to the ArrayList of books checked out.
	}

  }

  /**
   * Checks if this subscriber booksCheckedOut list contains a given book
   * @param book book to check if it is within this subscriber booksCheckedOut list
   * @return true if booksCheckedOut contains book, false otherwise
   */
  public boolean isBookInBooksCheckedOut(Book book) {
	return booksCheckedOut.contains(book);
  }

  /**
   * Returns a library book
   * @param book reference to the book to return by this subscriber
   */
  public void returnBook(Book book) {
	for(int i = 0; i < booksCheckedOut.size(); i++){ // Iterates through the checked out books
	  if (book.equals(booksCheckedOut.get(i))){ // Checks if both book objects are equal.
	    booksReturned.add(book); // Adds the books to the returned books ArrayList
	    booksCheckedOut.remove(i); // Removes it from the books checked out ArrayList
	  }
	}
	book.returnBook(); // Sets the book borrower_bar_code back to null
  }

  /**
   * Displays the list of the books checked out and not yet returned
   */
  public void displayBooksCheckedOut() {
	if (booksCheckedOut.isEmpty()) // empty list
	  System.out.println("No books checked out by this subscriber");
	else
	  // Traverse the list of books checked out by this subscriber and display its content
	  for (int i = 0; i < booksCheckedOut.size(); i++) {
		System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
		System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
		System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
	  }
  }

  /**
   * Displays the history of the returned books by this subscriber
   */
  public void displayHistoryBooksReturned() {
	if (booksReturned.isEmpty()) // empty list
	  System.out.println("No books returned by this subscriber");
	else
	  // Traverse the list of borrowed books already returned by this subscriber and display its
	  // content
	  for (int i = 0; i < booksReturned.size(); i++) {
		System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
		System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
		System.out.println("Author: " + booksReturned.get(i).getAuthor());
	  }
  }

  /**
   * Displays this subscriber's personal information
   */
  public void displayPersonalInfo() {
	System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
	System.out.println("  Name: " + name);
	System.out.println("  Address: " + address);
	System.out.println("  Phone number: " + phoneNumber);
  }
}
