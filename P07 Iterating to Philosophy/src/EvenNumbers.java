//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Even Numbers
// Files:           NONE
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

import java.util.Iterator;

/**
 * @author Rohan Mendiratta
 * Even number generator
 */
public class EvenNumbers implements Iterator<Integer> {

  private Integer number; // initial number
  private boolean calledOnce; // checks if next method has been called

  /**
   * Even number constructor
   * @param number initial number
   */
  public EvenNumbers(Integer number) {
	this.number = number;
	calledOnce = false;
  }

  /**
   *Finds the next value of iterator
   *@return next value in iteration
   */
  public Integer next() {
	if (!calledOnce) { // checks if this method has been called once
	  calledOnce = true;
	  return number;
	}
	number = number + 2;
	return number;
  }

  /**
   * Checks if there is a value in the next iteration
   * @return true if there is another iteration, false otherwise
   */
  public boolean hasNext() {
	return true;
  }
}
