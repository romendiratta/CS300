//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Support Ticket
// Files:           NONE
// Course:          CS300 Spring 2019
//
// Author:          Rohan Mendiratta
// Email:           rmendiratta@wisc.edu
// Lecturer's Name: Mouna Kacem
//
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
 * Class that represents each Support Ticjet
 * @author Rohan Mendiratta
 */
public class SupportTicket implements Comparable<SupportTicket> {

  private String message; // support ticket message

  /**
   * Constructs a support ticket with the specified message.
   * @param message in the support ticket
   */
  public SupportTicket(String message) {
	if (message == null) { // checks for a null message
	  throw new NullPointerException("WARNING: Message is null.");
	}
	this.message = message;
  }

  /**
   * Returns the toString representation of the support ticket
   * @return message of the support ticket
   */
  @Override
  public String toString() {
	return message;
  }

  /**
   * Compares two support tickets.
   * @return positive int if larger, negative if smaller, zero if the same
   */
  @Override
  public int compareTo(SupportTicket other) {
	if(this.message.length() > other.message.length()) { // checks length
	  return 1;
	}
	else if(this.message.length() < other.message.length()) {
	  return -1;
	}
	else { // compare lexicographical order if length is the same
	  return this.message.compareToIgnoreCase(other.message);

	}
  }
}

