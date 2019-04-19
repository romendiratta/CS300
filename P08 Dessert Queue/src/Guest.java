//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Guest
// Files:           ServingQueue.java, DessertSolvers.java
// Course:          CS300 Spring 2019
//
// Author:          Rohan Mendiratta
// Email:           rmendiratta@wisc.edu
// Lecturer's Name: Mouna Kacem
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
 * This guest class assigns an index and dietary restrictions to each guest.
 * @author Rohan Mendiratta
 */
public class Guest {

	public static int totalGuests = 0; // total amount of guests created
	private int index; // index of the nest guest
	private String dietaryRestriction; // dietary restrictions on the Guest

	/**
	 * Resets the counting of newly constructed guest indexes, so that the next new Guest that
	 * is created will be associated with the guest index of one.
	 * Note: that this will be helpful when running several tests, or solving solving several
	 * dessert simulation problems.  And that this should never be called from ServingQueue.java
	 */
	public static void resetNextGuestIndex() {
		totalGuests = 0;
	}

	/**
	 * Constructs a new guest with no dietary restrictions.  This guest should be associated with an
	 * index that is one larger than the previously constructed guest (or 1, if no prior guest, or
	 * if resetNextGuestIndex() was called more recently).
	 */
	public Guest() {
	  totalGuests++;
	  index = totalGuests;
	  dietaryRestriction = "";
	}

	/**
	 * Constructs a new guest with the specified dietary restrictions.  This guest should be
	 * associated with an index that is one larger than the previously constructed guest (or 1, if
	 * no prior guest, or if resetNextGuestIndex() was called more recently).
	 * @param dietaryRestriction describes requirements for what this guest can and cannot eat
	 */
	public Guest(String dietaryRestriction) {
	  totalGuests++;
	  index = totalGuests;
	  this.dietaryRestriction = dietaryRestriction;
	}

	/**
	 * Access whether this guest has any dietary restrictions or not
	 * @return true for guests constructed using new Guest(String), false otherwise
	 */
	public boolean hasDietaryRestriction() {
		if(dietaryRestriction.equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * The string representation of a Guest should be formatted as, for examples:
	 * #3(no dairy)
	 * for a guest with a guest index of 3 and the dietary restriction of "no dairy", or:
	 * #4
	 * for a guest with a guest index of 4 and no dietary restriction
	 * @return string representing the guest index and any dietary restriction they might have
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if(hasDietaryRestriction()) {
			return "#" + this.index + "(" + dietaryRestriction + ")";
		}
		else{
			return "#" + this.index;
		}
	}

}

