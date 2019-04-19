//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Book Class
// Files:           Subscriber.java, Book.Java, Library.java
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
public class Librarian {
  // instance fields
  private String username; // librarian's username
  private String password; // librarian password to have access to this application

  /**
   * Creates a new Librarian with a given name and a given password
   *
   * @param username username of this librarian
   * @param password password of this librarian to have access to this application
   */
  public Librarian(String username, String password) {
	this.username = username;
	this.password = password;
  }

  /**
   * Returns the name of this librarian
   * @return the name of this librarian
   */
  public String getUsername() {
	return this.username;
  }

  /**
   * Checks if a given password equals the password of this librarian
   * @param password a given password
   * @return true if a given password equals the password of this librarian, false otherwise
   */
  public boolean checkPassword(String password) {
	if (password.equals(this.password)) {
	  return true;
	}
	else{
	  return false;
	}
  }
}
