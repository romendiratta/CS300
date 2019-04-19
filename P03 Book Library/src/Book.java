//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Book Class
// Files:           Subscriber.java, Librarian.Java, Library.java
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

/**
 * @author Rohan
 * @author Paul
 * @version 1.0
 */
public class Book {
  // class/static fields
  private static int nextId = 1; // class variable that represents the identifier of the next book.
  // Instance fields
  private final int ID; // unique identifier of this book
  private String author; // name of the author of this book
  private String title; // title of this book
  private Integer borrowerCardBarCode; // card bar code of the borrower of this book
  // When borrowerCardBarCode == null, the book is available

  /**
   * Construct a new Book object and initialize its instance fields
   * @param title title of this new book
   * @param author author of this new book
   */
  public Book(String title, String author) {
	this.title = title; // sets the title
	this.author = author; // sets the author
	this.ID = nextId; // sets the next available id to the book
	nextId++;
	borrowerCardBarCode = null; // default value for book available
  }

  /**
   * Records the borrower's card bar code of this book if the book is available.
   * If this book is not available, this method does nothing.
   * @param borrowerCardBarCode
   */
  public void borrowBook(Integer borrowerCardBarCode) {
	this.borrowerCardBarCode = borrowerCardBarCode;
  }

  /**
   * Return the author of this book
   * @return the author
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * Return the the borrower's card bar code of this book if the book has been checked out or
   * null if not
   * @return the borrowerCardBarCode
   */
  public Integer getBorrowerCardBarCode() {
    if (borrowerCardBarCode == null) { // Checks if the book has not been checked out yet
	  return null;
	}
	else {
	  return this.borrowerCardBarCode;
	}
  }

  /**
   * Returns the ID of this Book object
   * @return the ID of this Book object
   */
  public int getID() {
    return this.ID;
  }

  /**
   * Return the title of this book
   * @return the title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Checks if this book is available
   * @return true if no one is borrowing this book, false otherwise
   */
  public boolean isAvailable() {
	// Checks if an Integer has been assigned to borrowerCardBarCode
    if (this.borrowerCardBarCode == null) {
      return true;
	}
	else {
	  return false;
	}
  }

  /**
   * Sets this book to be available. When the borrowerCardBarCode is set to null, no one is
   * borrowing it
   */
  public void returnBook() {
    this.borrowerCardBarCode = null;
  }
}
