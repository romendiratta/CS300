//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Finite Iterator
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
 * Creates a finite iterator
 * @param <T> type of iterator
 */
public class FiniteIterator <T> implements Iterator<T> {

  private int length; // length to iterate
  private int count; // current number of iterations
  private InfiniteIterator iterator; // infinite iterator object

  /**
   * Construtor for a finite iterator
   * @param iterator infinite iterator object
   * @param length number of iterations
   */
  public FiniteIterator(InfiniteIterator<T> iterator, int length) {
    this.iterator = iterator;
    this.length = length;
    this.count = 0;
  }

  /**
   * Finds the next value of iterator
   * @return next value in iteration
   */
  public T next() {
	count++; // adds tpo the count each iteration
    return (T) iterator.next();
  }

  /**
   * Checks if there is a value in the next iteration
   * @return true if there is another iteration, false otherwise
   */
  public boolean hasNext() {
    if (count < length) { // checks current iteration vs desired iterations
      return true;
	}
	return false;
  }
}
