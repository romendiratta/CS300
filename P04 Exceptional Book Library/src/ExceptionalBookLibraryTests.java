//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Exception Library Tests
// Files:           ExceptionalLibrary.java
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
//  X Write-up states that pair programming is allowed for this assignment.
//  X We have both read and understand the course Pair Programming Policy.
//  X We have registered our team prior to the team registration deadline.
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

import java.text.ParseException;

/**
 * @author Rohan Mendiratta
 * @author Paul Bartlett
 */
public class ExceptionalBookLibraryTests {

	/**
	 * Tests libraryParseBarCode() method
	 * @return true if passed, false if failed
	 */
	public static boolean testLibraryParseCardBarCode() {
	ExceptionalLibrary madisonLibrary = new ExceptionalLibrary
		("Madison, WI", "april", "abc"); // create new library
	boolean testPassed = true; // holds value if test passed
	try {
	  madisonLibrary.parseCardBarCode("2019123456", 0);
	} catch (ParseException e) { // catch exception and set testPassed to false
	  testPassed = false;

	}
	return testPassed;
  }

	/**
	 * tests libraryParsePinCode() method
	 * @return true if passed, false if failed
	 */
	public static boolean testLibraryParsePinCode() {
	ExceptionalLibrary madisonLibrary = new ExceptionalLibrary
		("Madison, WI", "april", "abc");
	boolean testPassed = true;
	try {
	  madisonLibrary.parsePinCode("1234", 0);
	} catch (ParseException e) {
	  testPassed = false;

	}
	return testPassed;
  }

	/**
	 * tests libraryParseBookId() method
	 * @return true if passed, false if failed
	 */
	public static boolean testLibraryParseBookId() {
	ExceptionalLibrary madisonLibrary = new ExceptionalLibrary
		("Madison, WI", "april", "abc");
	boolean testPassed = true;
	try {
	  madisonLibrary.parseBookId("123456789", 0);
	} catch (ParseException e) {
	  testPassed = false;

	}
	return testPassed;
  }

	/**
	 * tests libraryParseRunLibrarianCheckoutBookCommand() method
	 * @return true if passed, false if failed
	 */
	public static boolean testLibraryParseRunLibrarianCheckoutBookCommand() {
	ExceptionalLibrary madisonLibrary = new ExceptionalLibrary
		("Madison, WI", "april", "abc");
    boolean testPassed = true;
    String[] commands = new String[]{"3", "2019123456", "1"}; // create commands array
    try { // checks checkout command
      madisonLibrary.parseRunLibrarianCheckoutBookCommand(commands);
	} catch (ParseException e){
      testPassed = false;
	}
	return testPassed;
  }

	/**
	 * tests libraryParseRunSubscriberReturnBookCommand() method
	 * @return true if passed, false if failed
	 */
	public static boolean testLibraryParseRunSubscriberReturnBookCommand() {
	ExceptionalLibrary madisonLibrary = new ExceptionalLibrary
		("Madison, WI", "april", "abc");
	boolean testPassed = true;
	try {
	  String[] commands = new String[]{"2", "1"}; // create commands
	  Subscriber subsciber = new Subscriber("Rohan", 1234, "1234 Main St",
			  "1234"); // create subscriber
	  madisonLibrary.parseRunSubscriberReturnBookCommand(commands, subsciber); // checks return book
		// command
	} catch (InstantiationException e) {
	  testPassed = false;
	} catch (ParseException e){
	  testPassed = false;
	}
	return testPassed;
  }

  public static void main(String[] args){
    System.out.println(testLibraryParseBookId());
	System.out.println(testLibraryParseCardBarCode());
	System.out.println(testLibraryParsePinCode());
	System.out.println(testLibraryParseRunLibrarianCheckoutBookCommand());
	System.out.println(testLibraryParseRunSubscriberReturnBookCommand());
  }


}

