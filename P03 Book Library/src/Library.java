//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Book Class
// Files:           Subscriber.java, Librarian.Java, Book.java
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
import java.util.Scanner;

/**
 * @author Rohan
 * @author Paul
 * @version 1.0
 */
public class Library {
  // instance fields
  private String address; // Street address of this library
  private Librarian librarian; // this library's librarian. This library must have only ONE
  // librarian
  private ArrayList<Book> books; // list of the books in this library
  private ArrayList<Subscriber> subscribers; // list of this library's subscribers

  /**
   * Creates a new Library and initializes all its instance fields.
   * Initially both books and subscribers lists are empty.
   * @param address Address of this Library
   * @param librarianUsername username of the librarian of this book library
   * @param librarianPassword password of the librarian of this book library
   */
  public Library(String address, String librarianUsername, String librarianPassword) {
    this.address = address;
    this.librarian = new Librarian(librarianUsername, librarianPassword);
    books = new ArrayList<>();
    subscribers = new ArrayList<>();
  }

  /**
   * Returns the librarian of this library
   * @return the librarian
   */
  public Librarian getLibrarian() {
	return this.librarian;
  }

  /**
   * Returns the address of this library
   * @return the address
   */
  public String getAddress() {
	return this.address;
  }

  /**
   * Returns a Book given a book identifier if found, and null otherwise. If the book is not found,
   * this method displays the following message:
   * "Error: this book identifier didn't match any of our books identifiers."
   * @param bookId identifier of the book to find
   * @return reference to the Book if found and null otherwise
   */
  public Book findBook(int bookId) {
	// Iterates through the ArrayList of books
    for(int i = 0; i < books.size(); i++) {
	  if (books.get(i).getID() == bookId){ // Checks for matching book id's
	    return books.get(i);
	  }
	}
	// Error message if no book is found.
	System.out.println("Error: this book identifier didn't match any of our books identifiers.");
	return null;
  }

  /**
   * Returns the list of books having a given title in this library.
   * The comparison used by this method is case insensitive
   * @param title title of the book(s) to find
   * @return ArrayList of the books having a given title in this library
   * (0 or more books can be found)
   */
  public ArrayList<Book> findBookByTitle(String title) {
    ArrayList<Book> booksFound = new ArrayList<>(); // array of books that have been found
	// Iterates through the ArrayList of books
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getTitle().contains(title)) { // Checks for matching book titles
        booksFound.add(books.get(i)); // adds it to the books found array.
	  }
	}
	return booksFound;
  }

  /**
   * Returns the list of books having a given author.
   * The comparison used by this method is case insensitive
   * @param author author of the book(s) to find
   * @return ArrayList of the books having a given author (0 or more books can be found)
   */
  public ArrayList<Book> findBookByAuthor(String author) {
	ArrayList<Book> booksFound = new ArrayList<>(); // ArrayList of books found
	// Iterates through the array of books
	for (int i = 0; i < books.size(); i++) {
	  if (books.get(i).getAuthor().contains(author)) { // Checks for matching Authors
		booksFound.add(books.get(i)); // Adds it to the books found ArrayList
	  }
	}
	return booksFound;
  }

  /**
   * Adds a new book to the library (to the books list). This method displays the following message:
   * "Book with Title " + title + " is successfully added to the library."
   * @param title title of the new book
   * @param author author of the new book
   */
  public void addBook(String title, String author) {
    Book book = new Book(title, author); // Creates a new book object
    books.add(book); // Adds the object to the books ArrayList
    System.out.println("Book with Title " + title + " is successfully added to the library.");
  }

  /**
   * Removes a book given its identifier from the library (from books list)
   * @param bookId identifier of the book to remove
   * @return a reference to the removed book, and null if the book is not found in this library or
   * if it is not available
   */
  public Book removeBook(int bookId) {
    Book bookReference = null; // Reference of book object
	// Iterates through the books ArrayList
	for (int i = 0; i < books.size(); i++) {
	  if (books.get(i).getID() == bookId) { //  Checks for matching book ids
	    bookReference = books.get(i); // Sets the reference if found
	    books.remove(i); // Removes the book from the library
	  }
	}
	return bookReference;
  }

  /**
   * Adds a new subscriber to this library (to subscribers list). This method displays the following
   * message: "Library card with bar code " + card bar code + "
   * is successfully issued to the new subscriber " + name + "."
   * @param name name of the new subscriber
   * @param pin 4-digit personal identifier number of the new subscriber
   * @param address address of the new subscriber
   * @param phoneNumber phone number of the new subscriber
   */
  public void addSubscriber(String name, int pin, String address, String phoneNumber) {
    // Creates a new subscriber object
    Subscriber subscriber = new Subscriber(name, pin, address, phoneNumber);
    // Adds the subscriber to the library
    subscribers.add(subscriber);
    System.out.println("Library card with bar code " + subscriber.getCARD_BAR_CODE() +
		" is successfully issued to the new subscriber " + name + ".");

  }

  /**
   * Finds a subscriber given its cardBarCode. This method displayed the following message:
   * "Error: this card bar code didn't match any of our records." and returns null
   * if the provided cardBarCode did not match with any of the subscribers' card bar codes
   * @param cardBarCode of the subscriber to find
   * @return a reference to the subscriber if found, otherwise null
   */
  public Subscriber findSubscriber(int cardBarCode) {
	//Iterates through the subscriber ArrayList
    for (int i = 0; i < subscribers.size(); i++) {
	  if (subscribers.get(i).getCARD_BAR_CODE() == cardBarCode) { // Checks for matching bar codes
	    Subscriber subscriber = subscribers.get(i);
	    return subscriber;
	  }
	}
	// Returns an error if no matching barcodes were found.
	System.out.print("Error: this card bar code didn't match any of our records.");
	return null;
  }

  /**
   * Displays a list of books
   * @param books ArrayList of books
   */
  public static void displayBooks(ArrayList<Book> books) {
	// Traverse the list of books and display book id, title, author, and availability of each book
	for (int i = 0; i < books.size(); i++) {
	  System.out.print("<Book ID>: " + books.get(i).getID() + " ");
	  System.out.print("<Title>: " + books.get(i).getTitle() + " ");
	  System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
	  System.out.println("<Is Available>: " + books.get(i).isAvailable());
	}
  }

  /**
   * Displays the main menu for this book library application
   */
  private static void displayMainMenu() {
	System.out.println("\n--------------------------------------------------------");
	System.out.println("     Welcome to our Book Library Management System");
	System.out.println("--------------------------------------------------------");
	System.out.println("Enter one of the following options:");
	System.out.println("[1 <password>] Login as a librarian");
	System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
	System.out.println("[3] Exit"); // Exit the application
	System.out.println("--------------------------------------------------------");
  }

  /**
   * Displays the menu for a Subscriber
   */
  private static void displaySubscriberMenu() {
	System.out.println("\n--------------------------------------------------------");
	System.out.println("    Welcome to Subscriber's Space");
	System.out.println("--------------------------------------------------------");
	System.out.println("Enter one of the following options:");
	System.out.println("[1 <book ID>] Check out a book");
	System.out.println("[2 <book ID>] Return a book");
	System.out.println("[3 <title>] Search a Book by title");
	System.out.println("[4 <author>] Search a Book by author");
	System.out.println("[5] Print list of books checked out");
	System.out.println("[6] Print history of returned books");
	System.out.println("[7 <address>] Update address");
	System.out.println("[8 <phone number>] Update phone number");
	System.out.println("[9] Logout");
	System.out.println("--------------------------------------------------------");
  }

  /**
   * Displays the menu for the Librarian
   */
  private static void displayLibrarianMenu() {
	System.out.println("\n--------------------------------------------------------");
	System.out.println("    Welcome to Librarian's Space");
	System.out.println("--------------------------------------------------------");
	System.out.println("Enter one of the following options:");
	System.out.println("[1 <title> <author>] Add new Book");
	System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
	System.out.println("[3 <card bar code> <book ID>] Check out a Book");
	System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
	System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
	System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
	System.out.println("[7] Display All Books");
	System.out.println("[8 <book ID>] Remove a Book");
	System.out.println("[9] Logout");
	System.out.println("--------------------------------------------------------");
  }

  /**
   * Display the Application GoodBye and logout message.
   */
  private static void displayGoodByeLogoutMessage() {
	System.out.println("\n--------------------------------------------------------");
	System.out.println("       Thanks for Using our Book Library App!!!!");
	System.out.println("--------------------------------------------------------");
  }

  /**
   * Reads and processes the librarian commands according to the librarian menu
   *
   * @param scanner Scanner object used to read the librarian command lines
   */
  private void readProcessLibrarianCommand(Scanner scanner) {
	final String promptCommandLine = "ENTER COMMAND: ";
	displayLibrarianMenu(); // display the library management system librarian menu
	System.out.print(promptCommandLine);
	String command = scanner.nextLine(); // read user command line
	String[] commands = command.trim().split(" "); // split user command
	while (commands[0].trim().charAt(0) != '9') { // '9': Exit the menu
	  switch (commands[0].trim().charAt(0)) {
		case '1': // add new book
		  addBook(commands[1], commands[2]);
		  break;
		case '2': // adds a subscriber using the 4 fields as input
		  addSubscriber(commands[1], Integer.parseInt(commands[2]), commands[3], commands[4]);
		  break;
		case '3': // checks out a book to a subscriber
		  findSubscriber(Integer.parseInt(commands[1])).
			  checkoutBook(findBook(Integer.parseInt(commands[2])));
		      break;
		case '4': // returns a book for the subscriber
		  findSubscriber(Integer.parseInt(commands[1])).
			  returnBook(findBook(Integer.parseInt(commands[2])));
		  break;
		case '5': // finds the subscriber and displays the personal info
		  findSubscriber(Integer.parseInt(commands[1])).displayPersonalInfo();
		  break;
		case '6': // finds the subscriber and displays the books checked out
		  findSubscriber(Integer.parseInt(commands[1])).displayBooksCheckedOut();
		  break;
		case '7': // displays all the books in the library
		  displayBooks(books);
		  break;
		case '8': // removes a book from the library
		  removeBook(Integer.parseInt(commands[1]));
		  break;
		}
	  // read and split next user command line
	  displayLibrarianMenu(); // display the library management system main menu
	  System.out.print(promptCommandLine);
	  command = scanner.nextLine(); // read user command line
	  commands = command.trim().split(" "); // split user command line
	}
  }

  /**
   * Reads and processes the subscriber commands according to the subscriber menu
   *
   * @param subscriber Current logged in subscriber
   * @param scanner Scanner object used to read the librarian command lines
   */
  private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {
	final String promptCommandLine = "ENTER COMMAND: ";
	displaySubscriberMenu(); // display the library management system subscriber menu
	System.out.print(promptCommandLine);
	String command = scanner.nextLine(); // read user command line
	String[] commands = command.trim().split(" "); // split user command
	while (commands[0].trim().charAt(0) != '9') { // '9': Exit the application
	  switch (commands[0].trim().charAt(0)) {
		case '1': // Checks out a book as long as it exists in the library.
		  if (findBook(Integer.parseInt(commands[1])) == null) {
			break;
		  } else {
			subscriber.checkoutBook(findBook(Integer.parseInt(commands[1])));
		  }
		  break;
		case '2': // Returns a subscribers book
		  findBook(Integer.parseInt(commands[1]));
		  break;
		case '3': // Displays the books after finding them by title
		  displayBooks(findBookByTitle(commands[1]));
		  break;
		case '4': // Displays the books after finding them by author
		  displayBooks(findBookByAuthor(commands[1]));
		  break;
		case '5': // displays the books checked out by the subscriber
		  subscriber.displayBooksCheckedOut();
		  break;
		case '6': // Displays the history of the books returned
		  subscriber.displayHistoryBooksReturned();
		  break;
		case '7': // sets the address of the subscriber
		  subscriber.setAddress(commands[1]);
		  break;
		case '8': // sets the phone number of the subscriber
		  subscriber.setPhoneNumber(commands[1]);
		  break;
	  }
	}
	  // read and split next user command line
	  displaySubscriberMenu(); // display the library management system main menu
	  System.out.print(promptCommandLine);
	  command = scanner.nextLine(); // read user command line
	  commands = command.trim().split(" "); // split user command line
  }

  /**
   * Reads and processes the user commands with respect to the menu of this application
   *
   * @param scanner Scanner object used to read the user command lines
   */
  public void readProcessUserCommand(Scanner scanner) {
	final String promptCommandLine = "ENTER COMMAND: ";
	displayMainMenu(); // display the library management system main menu
	System.out.print(promptCommandLine);
	String command = scanner.nextLine(); // read user command line
	String[] commands = command.trim().split(" "); // split user command
	while (commands[0].trim().charAt(0) != '3') { // '3': Exit the application
	  switch (commands[0].trim().charAt(0)) {
		case '1': // login as librarian commands[1]: password
		  if (this.librarian.checkPassword(commands[1])) {
			// read and process librarian commands
			readProcessLibrarianCommand(scanner);
		  } else { // error password
			System.out.println("Error: Password incorrect!");
		  }
		  break;
		case '2': // login as subscriber commands[1]: card bar code
		  Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
		  if (subscriber != null) {
			if (subscriber.getPin() == Integer.parseInt(commands[2])) // correct PIN
			  // read and process subscriber commands
			  readProcessSubscriberCommand(subscriber, scanner);
			else
			  System.out.println("Error: Incorrect PIN.");
		  }
		  break;
	  }
	  // read and split next user command line
	  displayMainMenu(); // display the library management system main menu
	  System.out.print(promptCommandLine);
	  command = scanner.nextLine(); // read user command line
	  commands = command.trim().split(" "); // split user command line
	}
  }

  /**
   * Main method that represents the driver for this application
   *
   * @param args
   */
  public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in); // create a scanner object to read user inputs
	// create a new library object
	Library madisonLibrary = new Library(
		"Madison, WI", "april", "abc");
	// read and process user command lines
	madisonLibrary.readProcessUserCommand(scanner);
	displayGoodByeLogoutMessage(); // display good bye message
	scanner.close();// close this scanner
  }
}
