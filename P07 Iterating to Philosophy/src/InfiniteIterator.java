//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Infinite Iterator
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
import java.util.function.Function;

/**
 * @author Rohan Mendiratta
 * Creates an infinite iterator
 * @param <T> type of iterator
 */
public class InfiniteIterator <T> implements Iterator<T> {

  private T initialValue;  // initial value
  private boolean calledOnce; // checks if the next method has been called once
  private Function function; // stores the function object

  /**
   * Infinite Iterator constructor
   * @param initialValue initial value
   * @param function to be applied
   */
  public InfiniteIterator(T initialValue, Function<T, T> function) {
	this.initialValue = initialValue;
	calledOnce = false;
	this.function = function;
  }

  /**
   *Finds the next value of iterator
   *@return next value in iteration
   */
  public T next() {
	if (!calledOnce) { // checks if this method has been called once
	  calledOnce = true;
	  return initialValue;
	}
	initialValue = (T) function.apply(initialValue); // sets the next value
	return initialValue;
  }

  /**
   * Checks if there is a value in the next iteration
   * @return true if there is another iteration, false otherwise
   */
  public boolean hasNext() {
	return true;
  }

}